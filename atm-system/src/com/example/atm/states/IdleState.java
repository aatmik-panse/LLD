package com.example.atm.states;

import com.example.atm.ATM;
import com.example.atm.model.Card;

public class IdleState implements ATMState {
    
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        if (atm.getBankService().validateCard(cardNumber)) {
            atm.setCurrentCard(new Card(cardNumber, "BANK"));
            atm.setState(atm.getCardInsertedState());
            atm.displayMessage("Card accepted. Please enter your PIN.");
        } else {
            atm.displayMessage("Invalid card. Card ejected.");
        }
    }
    
    @Override
    public void enterPin(ATM atm, String pin) {
        atm.displayMessage("Please insert card first.");
    }
    
    @Override
    public void selectOperation(ATM atm, String operation) {
        atm.displayMessage("Please insert card first.");
    }
    
    @Override
    public void enterAmount(ATM atm, double amount) {
        atm.displayMessage("Please insert card first.");
    }
    
    @Override
    public void enterNewPin(ATM atm, String newPin, String confirmPin) {
        atm.displayMessage("Please insert card first.");
    }
    
    @Override
    public void ejectCard(ATM atm) {
        atm.displayMessage("No card inserted.");
    }
    
    @Override
    public void cancel(ATM atm) {
        atm.displayMessage("No transaction in progress.");
    }
}