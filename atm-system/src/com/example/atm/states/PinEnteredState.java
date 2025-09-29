package com.example.atm.states;

import com.example.atm.ATM;

public class PinEnteredState implements ATMState {
    
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        atm.displayMessage("Card already inserted and authenticated.");
    }
    
    @Override
    public void enterPin(ATM atm, String pin) {
        atm.displayMessage("PIN already entered. Please select operation.");
    }
    
    @Override
    public void selectOperation(ATM atm, String operation) {
        switch (operation.toLowerCase()) {
            case "1":
            case "withdrawal":
                atm.setState(atm.getTransactionState());
                atm.displayMessage("Enter withdrawal amount:");
                break;
            case "2":
            case "deposit":
                atm.setState(atm.getTransactionState());
                atm.displayMessage("Insert cash into deposit slot and confirm amount:");
                break;
            case "3":
            case "balance":
                atm.displayMessage("Current Balance: ₹" + String.format("%.2f", atm.getCurrentAccount().getBalance()));
                atm.displayMessage("Transaction complete. Please select another option or cancel.");
                break;
            case "4":
            case "statement":
                atm.getPrinterService().printMiniStatement(
                    atm.getCurrentAccount(),
                    atm.getBankService().getRecentTransactions(atm.getCurrentAccount().getAccountNumber(), 5)
                );
                atm.displayMessage("Mini statement printed. Please select another option or cancel.");
                break;
            case "5":
            case "changepin":
                atm.setState(atm.getPinChangeState());
                atm.displayMessage("Enter new PIN:");
                break;
            default:
                atm.displayMessage("Invalid selection. Please choose 1-5.");
        }
    }
    
    @Override
    public void enterAmount(ATM atm, double amount) {
        atm.displayMessage("Please select operation first.");
    }
    
    @Override
    public void enterNewPin(ATM atm, String newPin, String confirmPin) {
        atm.displayMessage("Please select Change PIN option first.");
    }
    
    @Override
    public void ejectCard(ATM atm) {
        atm.setCurrentCard(null);
        atm.setCurrentAccount(null);
        atm.setState(atm.getIdleState());
        atm.displayMessage("Card ejected. Thank you!");
    }
    
    @Override
    public void cancel(ATM atm) {
        ejectCard(atm);
    }
}