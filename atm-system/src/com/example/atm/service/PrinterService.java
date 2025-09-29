package com.example.atm.service;

import com.example.atm.model.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class PrinterService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public void printTransactionReceipt(Transaction transaction, Account account) {
        System.out.println("\n========== TRANSACTION RECEIPT ==========");
        System.out.println("Date/Time: " + transaction.getTimestamp().format(formatter));
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.println("Account: " + maskAccountNumber(account.getAccountNumber()));
        System.out.println("Transaction Type: " + transaction.getType());
        
        if (transaction.getAmount() > 0) {
            System.out.println("Amount: ₹" + String.format("%.2f", transaction.getAmount()));
        }
        
        System.out.println("Available Balance: ₹" + String.format("%.2f", account.getBalance()));
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("=========================================\n");
    }
    
    public void printMiniStatement(Account account, List<Transaction> transactions) {
        System.out.println("\n============ MINI STATEMENT =============");
        System.out.println("Account: " + maskAccountNumber(account.getAccountNumber()));
        System.out.println("Current Balance: ₹" + String.format("%.2f", account.getBalance()));
        System.out.println("Last " + transactions.size() + " Transactions:");
        System.out.println("-----------------------------------------");
        
        for (Transaction txn : transactions) {
            String type = txn.getType().toString().substring(0, 4);
            System.out.printf("%s | %s | ₹%.2f%n", 
                txn.getTimestamp().format(formatter),
                type,
                txn.getAmount());
        }
        System.out.println("=========================================\n");
    }
    
    public void printCashDispenseDetails(Map<Integer, Integer> dispensed) {
        System.out.println("\n======== CASH DISPENSED ========");
        for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) {
            System.out.println("₹" + entry.getKey() + " x " + entry.getValue());
        }
        System.out.println("================================\n");
    }
    
    private String maskAccountNumber(String accountNumber) {
        if (accountNumber.length() <= 4) return accountNumber;
        return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
    }
}