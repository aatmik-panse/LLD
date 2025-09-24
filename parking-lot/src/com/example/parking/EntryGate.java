package com.example.parking;

public class EntryGate {
    private final int gateId;
    
    public EntryGate(int gateId) {
        this.gateId = gateId;
    }
    
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        String ticketId = "TICKET_" + System.currentTimeMillis();
        return new Ticket(ticketId, spot, vehicle);
    }
    
    public int getGateId() {
        return gateId;
    }
}