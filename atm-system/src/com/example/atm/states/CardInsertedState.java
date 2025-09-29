package com.example.atm.states;

import com.example.atm.ATM;
import com.example.atm.model.Account;

public class CardInsertedState implements ATMState {
    
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        atm.displayMessage("Card already inserted.");
    }
    
    @Override
    public void enterPin(ATM atm, String pin) {
        if (atm.getBankService().validatePin(atm.getCurrentCard().getCardNumber(), pin)) {
            Account account = atm.getBankService().getAccount(atm.getCurrentCard().getCardNumber());
            atm.setCurrentAccount(account);
            atm.setState(atm.getPinEnteredState());
            atm.displayMessage("PIN accepted. Please select operation:\n1. Withdrawal\n2. Deposit\n3. Balance Inquiry\n4. Mini Statement\n5. Change PIN");
        } else {
            atm.displayMessage("Invalid PIN. Card ejected.");
            atm.setCurrentCard(null);
            atm.setState(atm.getIdleState());
        }
    }
    
    @Override
    public void selectOperation(ATM atm, String operation) {
        atm.displayMessage("Please enter PIN first.");
    }
    
    @Override
    public void enterAmount(ATM atm, double amount) {
        atm.displayMessage("Please enter PIN first.");
    }
    
    @Override
    public void enterNewPin(ATM atm, String newPin, String confirmPin) {
        atm.displayMessage("Please enter PIN first.");
    }
    
    @Override
    public void ejectCard(ATM atm) {
        atm.setCurrentCard(null);
        atm.setState(atm.getIdleState());
        atm.displayMessage("Card ejected.");
    }
    
    @Override
    public void cancel(ATM atm) {
        ejectCard(atm);
    }
}