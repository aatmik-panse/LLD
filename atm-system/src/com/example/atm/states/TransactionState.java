package com.example.atm.states;

import com.example.atm.ATM;
import com.example.atm.model.*;
import java.util.Map;

public class TransactionState implements ATMState {
    private String currentOperation;
    
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        atm.displayMessage("Transaction in progress. Please complete or cancel.");
    }
    
    @Override
    public void enterPin(ATM atm, String pin) {
        atm.displayMessage("Transaction in progress. Please complete or cancel.");
    }
    
    @Override
    public void selectOperation(ATM atm, String operation) {
        this.currentOperation = operation;
        atm.displayMessage("Enter amount:");
    }
    
    @Override
    public void enterAmount(ATM atm, double amount) {
        Account account = atm.getCurrentAccount();
        
        if (currentOperation == null) {
            // Determine operation from state context
            currentOperation = "withdrawal"; // Default assumption
        }
        
        if (currentOperation.equals("withdrawal") || currentOperation.equals("1")) {
            if (amount <= 0 || amount % 10 != 0) {
                atm.displayMessage("Invalid amount. Please enter amount in multiples of 10.");
                return;
            }
            
            if (!atm.getCashInventory().canDispense(amount)) {
                atm.displayMessage("Unable to dispense requested amount. Try different amount.");
                return;
            }
            
            if (atm.getBankService().withdraw(account.getAccountNumber(), amount)) {
                Map<Integer, Integer> dispensed = atm.getCashInventory().dispense(amount);
                atm.getPrinterService().printCashDispenseDetails(dispensed);
                
                // Create transaction record
                String transactionId = "TXN" + System.currentTimeMillis();
                Transaction transaction = new Transaction(transactionId, account.getAccountNumber(), 
                    TransactionType.WITHDRAWAL, amount, "Cash Withdrawal");
                atm.getPrinterService().printTransactionReceipt(transaction, account);
                
                atm.displayMessage("Please collect your cash and receipt.");
                atm.setState(atm.getPinEnteredState());
            } else {
                atm.displayMessage("Insufficient balance. Available: ₹" + String.format("%.2f", account.getBalance()));
            }
        } else if (currentOperation.equals("deposit") || currentOperation.equals("2")) {
            if (amount <= 0) {
                atm.displayMessage("Invalid amount.");
                return;
            }
            
            if (atm.getBankService().deposit(account.getAccountNumber(), amount)) {
                String transactionId = "TXN" + System.currentTimeMillis();
                Transaction transaction = new Transaction(transactionId, account.getAccountNumber(), 
                    TransactionType.DEPOSIT, amount, "Cash Deposit");
                atm.getPrinterService().printTransactionReceipt(transaction, account);
                
                atm.displayMessage("Deposit successful.");
                atm.setState(atm.getPinEnteredState());
            } else {
                atm.displayMessage("Deposit failed. Please try again.");
            }
        }
    }
    
    @Override
    public void enterNewPin(ATM atm, String newPin, String confirmPin) {
        atm.displayMessage("Transaction in progress. Please complete or cancel.");
    }
    
    @Override
    public void ejectCard(ATM atm) {
        atm.displayMessage("Please complete transaction or cancel first.");
    }
    
    @Override
    public void cancel(ATM atm) {
        atm.setState(atm.getPinEnteredState());
        atm.displayMessage("Transaction cancelled. Please select operation:");
    }
}