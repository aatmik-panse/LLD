package com.example.parking;

public class HourlyPricingStrategy implements PricingStrategy {
    private final double hourlyRate;
    
    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculatePrice(int hours) {
        return hours * hourlyRate;
    }
}