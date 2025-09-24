package com.example.parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExitGate {
    private final int gateId;
    private final PricingStrategy pricingStrategy;
    
    public ExitGate(int gateId, PricingStrategy pricingStrategy) {
        this.gateId = gateId;
        this.pricingStrategy = pricingStrategy;
    }
    
    public double processExit(Ticket ticket) {
        ticket.setExitTime(LocalDateTime.now());
        int hoursParked = (int) ChronoUnit.HOURS.between(ticket.getEntryTime(), ticket.getExitTime());
        hoursParked = Math.max(hoursParked, 1);
        return pricingStrategy.calculatePrice(hoursParked);
    }
    
    public int getGateId() {
        return gateId;
    }
}