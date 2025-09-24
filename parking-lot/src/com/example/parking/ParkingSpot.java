package com.example.parking;

public class ParkingSpot {
    private final int spotNumber;
    private final SpotSize spotSize;
    private Vehicle currentVehicle;
    private boolean isAvailable;
    
    public ParkingSpot(int spotNumber, SpotSize spotSize) {
        this.spotNumber = spotNumber;
        this.spotSize = spotSize;
        this.isAvailable = true;
    }
    
    public boolean canFit(Vehicle vehicle) {
        return isAvailable && vehicle.getRequiredSpotSize() == spotSize;
    }
    
    public void park(Vehicle vehicle) {
        if (canFit(vehicle)) {
            this.currentVehicle = vehicle;
            this.isAvailable = false;
        }
    }
    
    public void vacate() {
        this.currentVehicle = null;
        this.isAvailable = true;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
    
    public SpotSize getSpotSize() {
        return spotSize;
    }
    
    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
}