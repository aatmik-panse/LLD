package com.example.parking;

public class Vehicle {
    private String licensePlate;
    private SpotSize requiredSpotSize;
    
    public Vehicle(String licensePlate, SpotSize requiredSpotSize) {
        this.licensePlate = licensePlate;
        this.requiredSpotSize = requiredSpotSize;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public SpotSize getRequiredSpotSize() {
        return requiredSpotSize;
    }
}