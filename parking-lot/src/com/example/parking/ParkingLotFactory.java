package com.example.parking;

public class ParkingLotFactory {
    
    public static ParkingLot createBasicParkingLot() {
        ParkingLot parkingLot = new ParkingLot("Main Parking", new NearestSlotStrategy());
        
        // Add spots directly to parking lot
        int spotCounter = 1;
        
        // Add 50 small spots
        for (int i = 0; i < 50; i++) {
            parkingLot.addSpot(new ParkingSpot(spotCounter++, SpotSize.SMALL));
        }
        
        // Add 30 medium spots
        for (int i = 0; i < 30; i++) {
            parkingLot.addSpot(new ParkingSpot(spotCounter++, SpotSize.MEDIUM));
        }
        
        // Add 15 large spots
        for (int i = 0; i < 15; i++) {
            parkingLot.addSpot(new ParkingSpot(spotCounter++, SpotSize.LARGE));
        }
        
        // Add 10 electric spots
        for (int i = 0; i < 10; i++) {
            parkingLot.addSpot(new ParkingSpot(spotCounter++, SpotSize.ELECTRIC));
        }
        
        // Add gates
        parkingLot.addEntryGate(new EntryGate(1));
        parkingLot.addEntryGate(new EntryGate(2));
        
        parkingLot.addExitGate(new ExitGate(1, new HourlyPricingStrategy(5.0)));
        parkingLot.addExitGate(new ExitGate(2, new HourlyPricingStrategy(5.0)));
        
        return parkingLot;
    }
}