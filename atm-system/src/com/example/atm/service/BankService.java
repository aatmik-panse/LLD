package com.example.atm.service;

import com.example.atm.model.*;
import java.util.*;

public class BankService {
    private Map<String, Account> accounts;
    private List<Transaction> transactions;
    
    public BankService() {
        accounts = new HashMap<>();
        transactions = new ArrayList<>();
        initializeSampleAccounts();
    }
    
    private void initializeSampleAccounts() {
        accounts.put("1234567890", new Account("1234567890", "1234", 10000, "SBI"));
        accounts.put("0987654321", new Account("0987654321", "5678", 25000, "HDFC"));
        accounts.put("1111222233", new Account("1111222233", "9999", 5000, "ICICI"));
    }
    
    public boolean validateCard(String cardNumber) {
        return accounts.containsKey(cardNumber);
    }
    
    public boolean validatePin(String cardNumber, String pin) {
        Account account = accounts.get(cardNumber);
        return account != null && account.getPin().equals(pin);
    }
    
    public Account getAccount(String cardNumber) {
        return accounts.get(cardNumber);
    }
    
    public boolean withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            recordTransaction(accountNumber, TransactionType.WITHDRAWAL, amount, "Cash Withdrawal");
            return true;
        }
        return false;
    }
    
    public boolean deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            recordTransaction(accountNumber, TransactionType.DEPOSIT, amount, "Cash Deposit");
            return true;
        }
        return false;
    }
    
    public boolean changePin(String accountNumber, String newPin) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setPin(newPin);
            recordTransaction(accountNumber, TransactionType.PIN_CHANGE, 0, "PIN Changed");
            return true;
        }
        return false;
    }
    
    public List<Transaction> getRecentTransactions(String accountNumber, int count) {
        return transactions.stream()
            .filter(t -> t.getAccountNumber().equals(accountNumber))
            .sorted((t1, t2) -> t2.getTimestamp().compareTo(t1.getTimestamp()))
            .limit(count)
            .toList();
    }
    
    private void recordTransaction(String accountNumber, TransactionType type, double amount, String description) {
        String transactionId = "TXN" + System.currentTimeMillis();
        transactions.add(new Transaction(transactionId, accountNumber, type, amount, description));
    }
}