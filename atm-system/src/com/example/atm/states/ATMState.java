package com.example.atm.states;

import com.example.atm.ATM;

public interface ATMState {
    void insertCard(ATM atm, String cardNumber);
    void enterPin(ATM atm, String pin);
    void selectOperation(ATM atm, String operation);
    void enterAmount(ATM atm, double amount);
    void enterNewPin(ATM atm, String newPin, String confirmPin);
    void ejectCard(ATM atm);
    void cancel(ATM atm);
}