package com.example.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final String name;
    private final List<ParkingSpot> spots;
    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;
    private final SlotAllocationStrategy allocationStrategy;
    private final Map<String, Ticket> activeTickets;
    private final Map<SpotSize, Integer> availableSpots;
    
    public ParkingLot(String name, SlotAllocationStrategy allocationStrategy) {
        this.name = name;
        this.allocationStrategy = allocationStrategy;
        this.spots = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        this.availableSpots = new HashMap<>();
        initializeSpotCounts();
    }
    
    private void initializeSpotCounts() {
        for (SpotSize size : SpotSize.values()) {
            availableSpots.put(size, 0);
        }
    }
    
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
        if (spot.isAvailable()) {
            availableSpots.put(spot.getSpotSize(), 
                availableSpots.get(spot.getSpotSize()) + 1);
        }
    }
    
    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }
    
    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }
    
    public Ticket parkVehicle(Vehicle vehicle) {
        List<ParkingSpot> availableSpotsList = spots.stream()
                .filter(ParkingSpot::isAvailable)
                .toList();
        
        ParkingSpot spot = allocationStrategy.findSpot(vehicle, availableSpotsList);
        if (spot != null) {
            spot.park(vehicle);
            updateAvailability(spot, false);
            
            Ticket ticket = entryGates.get(0).generateTicket(vehicle, spot);
            activeTickets.put(ticket.getTicketId(), ticket);
            return ticket;
        }
        return null;
    }
    
    public double removeVehicle(String ticketId, ExitGate exitGate) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            ParkingSpot spot = ticket.getParkingSpot();
            spot.vacate();
            updateAvailability(spot, true);
            
            activeTickets.remove(ticketId);
            return exitGate.processExit(ticket);
        }
        return 0;
    }
    
    private void updateAvailability(ParkingSpot spot, boolean available) {
        int current = availableSpots.get(spot.getSpotSize());
        availableSpots.put(spot.getSpotSize(), available ? current + 1 : current - 1);
    }
    
    public String getName() {
        return name;
    }
    
    public List<ParkingSpot> getSpots() {
        return spots;
    }
    
    public Map<SpotSize, Integer> getAvailableSpotCount() {
        return availableSpots;
    }
}