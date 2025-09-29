package com.example.atm;

import com.example.atm.model.*;
import com.example.atm.service.*;
import com.example.atm.states.*;

public class ATM {
    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private CashInventory cashInventory;
    private BankService bankService;
    private PrinterService printerService;
    
    // States
    private IdleState idleState;
    private CardInsertedState cardInsertedState;
    private PinEnteredState pinEnteredState;
    private TransactionState transactionState;
    private PinChangeState pinChangeState;
    
    public ATM() {
        cashInventory = new CashInventory();
        bankService = new BankService();
        printerService = new PrinterService();
        
        // Initialize states
        idleState = new IdleState();
        cardInsertedState = new CardInsertedState();
        pinEnteredState = new PinEnteredState();
        transactionState = new TransactionState();
        pinChangeState = new PinChangeState();
        
        currentState = idleState;
    }
    
    // State methods
    public void insertCard(String cardNumber) {
        currentState.insertCard(this, cardNumber);
    }
    
    public void enterPin(String pin) {
        currentState.enterPin(this, pin);
    }
    
    public void selectOperation(String operation) {
        currentState.selectOperation(this, operation);
    }
    
    public void enterAmount(double amount) {
        currentState.enterAmount(this, amount);
    }
    
    public void enterNewPin(String newPin, String confirmPin) {
        currentState.enterNewPin(this, newPin, confirmPin);
    }
    
    public void ejectCard() {
        currentState.ejectCard(this);
    }
    
    public void cancel() {
        currentState.cancel(this);
    }
    
    // Getters and Setters
    public void setState(ATMState state) { this.currentState = state; }
    public ATMState getCurrentState() { return currentState; }
    public Card getCurrentCard() { return currentCard; }
    public void setCurrentCard(Card card) { this.currentCard = card; }
    public Account getCurrentAccount() { return currentAccount; }
    public void setCurrentAccount(Account account) { this.currentAccount = account; }
    public CashInventory getCashInventory() { return cashInventory; }
    public BankService getBankService() { return bankService; }
    public PrinterService getPrinterService() { return printerService; }
    
    // State instances
    public IdleState getIdleState() { return idleState; }
    public CardInsertedState getCardInsertedState() { return cardInsertedState; }
    public PinEnteredState getPinEnteredState() { return pinEnteredState; }
    public TransactionState getTransactionState() { return transactionState; }
    public PinChangeState getPinChangeState() { return pinChangeState; }
    
    public void displayMessage(String message) {
        System.out.println("ATM Display: " + message);
    }
}