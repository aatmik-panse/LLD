package com.example.atm.model;

public class Card {
    private String cardNumber;
    private String bankCode;
    private boolean isValid;
    
    public Card(String cardNumber, String bankCode) {
        this.cardNumber = cardNumber;
        this.bankCode = bankCode;
        this.isValid = true;
    }
    
    public String getCardNumber() { return cardNumber; }
    public String getBankCode() { return bankCode; }
    public boolean isValid() { return isValid; }
    public void setValid(boolean valid) { this.isValid = valid; }
}