package com.example.atm;

import java.util.Scanner;

public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM System!");
        System.out.println("Available test cards: 1234567890 (PIN: 1234), 0987654321 (PIN: 5678)");
        
        while (true) {
            System.out.println("\n=== ATM SYSTEM ===");
            System.out.println("1. Insert Card");
            System.out.println("2. Enter PIN");
            System.out.println("3. Select Operation");
            System.out.println("4. Enter Amount");
            System.out.println("5. Change PIN");
            System.out.println("6. Cancel");
            System.out.println("7. Eject Card");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    atm.insertCard(cardNumber);
                    break;
                case "2":
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    atm.enterPin(pin);
                    break;
                case "3":
                    System.out.println("Select operation:");
                    System.out.println("1. Withdrawal");
                    System.out.println("2. Deposit");
                    System.out.println("3. Balance Inquiry");
                    System.out.println("4. Mini Statement");
                    System.out.println("5. Change PIN");
                    System.out.print("Enter choice: ");
                    String operation = scanner.nextLine();
                    atm.selectOperation(operation);
                    break;
                case "4":
                    System.out.print("Enter amount: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        atm.enterAmount(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount format.");
                    }
                    break;
                case "5":
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();
                    System.out.print("Confirm new PIN: ");
                    String confirmPin = scanner.nextLine();
                    atm.enterNewPin(newPin, confirmPin);
                    break;
                case "6":
                    atm.cancel();
                    break;
                case "7":
                    atm.ejectCard();
                    break;
                case "8":
                    System.out.println("Thank you for using our ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}