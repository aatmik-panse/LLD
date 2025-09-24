package com.example.parking;

import java.util.List;

public class NearestSlotStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots) {
        return spots.stream()
                .filter(spot -> spot.canFit(vehicle))
                .findFirst()
                .orElse(null);
    }
}