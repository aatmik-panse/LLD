package com.example.atm.states;

import com.example.atm.ATM;

public class PinChangeState implements ATMState {
    private String newPin;
    
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        atm.displayMessage("PIN change in progress. Please complete or cancel.");
    }
    
    @Override
    public void enterPin(ATM atm, String pin) {
        atm.displayMessage("PIN change in progress. Please complete or cancel.");
    }
    
    @Override
    public void selectOperation(ATM atm, String operation) {
        atm.displayMessage("PIN change in progress. Please complete or cancel.");
    }
    
    @Override
    public void enterAmount(ATM atm, double amount) {
        atm.displayMessage("PIN change in progress. Please complete or cancel.");
    }
    
    @Override
    public void enterNewPin(ATM atm, String newPin, String confirmPin) {
        if (this.newPin == null) {
            if (newPin.length() == 4 && newPin.matches("\\d+")) {
                this.newPin = newPin;
                atm.displayMessage("Confirm new PIN:");
            } else {
                atm.displayMessage("PIN must be 4 digits. Enter new PIN:");
            }
        } else {
            if (this.newPin.equals(confirmPin)) {
                if (atm.getBankService().changePin(atm.getCurrentAccount().getAccountNumber(), newPin)) {
                    atm.displayMessage("PIN changed successfully.");
                    this.newPin = null;
                    atm.setState(atm.getPinEnteredState());
                } else {
                    atm.displayMessage("PIN change failed. Please try again.");
                    this.newPin = null;
                }
            } else {
                atm.displayMessage("PINs don't match. Enter new PIN:");
                this.newPin = null;
            }
        }
    }
    
    @Override
    public void ejectCard(ATM atm) {
        atm.displayMessage("Please complete PIN change or cancel first.");
    }
    
    @Override
    public void cancel(ATM atm) {
        this.newPin = null;
        atm.setState(atm.getPinEnteredState());
        atm.displayMessage("PIN change cancelled. Please select operation:");
    }
}