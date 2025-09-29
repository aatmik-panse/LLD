package com.example.atm.model;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private String bankCode;
    
    public Account(String accountNumber, String pin, double balance, String bankCode) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.bankCode = bankCode;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getBankCode() { return bankCode; }
}