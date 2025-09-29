package com.example.atm.model;

import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    private Map<Integer, Integer> denominations;
    
    public CashInventory() {
        denominations = new HashMap<>();
        // Initialize with common denominations
        denominations.put(500, 100);
        denominations.put(200, 50);
        denominations.put(100, 200);
        denominations.put(50, 100);
        denominations.put(20, 200);
    }
    
    public boolean canDispense(double amount) {
        return calculateMinimumNotes(amount) != null;
    }
    
    public Map<Integer, Integer> dispense(double amount) {
        Map<Integer, Integer> dispensed = calculateMinimumNotes(amount);
        if (dispensed != null) {
            // Deduct from inventory
            for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) {
                int denom = entry.getKey();
                int count = entry.getValue();
                denominations.put(denom, denominations.get(denom) - count);
            }
        }
        return dispensed;
    }
    
    private Map<Integer, Integer> calculateMinimumNotes(double amount) {
        int amt = (int) amount;
        Map<Integer, Integer> result = new HashMap<>();
        Integer[] denoms = {500, 200, 100, 50, 20};
        
        for (int denom : denoms) {
            int available = denominations.getOrDefault(denom, 0);
            int needed = Math.min(amt / denom, available);
            if (needed > 0) {
                result.put(denom, needed);
                amt -= needed * denom;
            }
        }
        
        return amt == 0 ? result : null;
    }
    
    public void addCash(int denomination, int count) {
        denominations.put(denomination, 
            denominations.getOrDefault(denomination, 0) + count);
    }
}