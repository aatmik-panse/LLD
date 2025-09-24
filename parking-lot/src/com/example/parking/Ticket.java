package com.example.parking;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private final Vehicle vehicle;
    
    public Ticket(String ticketId, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
    }
    
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
    
    public String getTicketId() {
        return ticketId;
    }
    
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
}