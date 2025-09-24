package com.example.parking;

import java.util.List;

public interface SlotAllocationStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots);
}