package com.example.parking;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLotFactory.createBasicParkingLot();
        
        Vehicle car1 = new Vehicle("ABC-123", SpotSize.SMALL);
        Vehicle car2 = new Vehicle("XYZ-789", SpotSize.SMALL);
        Vehicle bus = new Vehicle("BUS-001", SpotSize.LARGE);
        Vehicle electricVehicle = new Vehicle("E-CAR-001", SpotSize.ELECTRIC);
        
        System.out.println("=== This is our Parking Lot ===");
        
        Ticket ticket1 = parkingLot.parkVehicle(car1);
        if (ticket1 != null) {
            System.out.println("Vehicle " + car1.getLicensePlate() + " parked. Ticket: " + ticket1.getTicketId());
        }
        
        Ticket ticket2 = parkingLot.parkVehicle(car2);
        if (ticket2 != null) {
            System.out.println("Vehicle " + car2.getLicensePlate() + " parked. Ticket: " + ticket2.getTicketId());
        }
        
        Ticket ticket3 = parkingLot.parkVehicle(bus);
        if (ticket3 != null) {
            System.out.println("Vehicle " + bus.getLicensePlate() + " parked. Ticket: " + ticket3.getTicketId());
        }
        
        Ticket ticket4 = parkingLot.parkVehicle(electricVehicle);
        if (ticket4 != null) {
            System.out.println("Vehicle " + electricVehicle.getLicensePlate() + " parked. Ticket: " + ticket4.getTicketId());
        }
        
        // Print availability
        System.out.println("\nCurrent availability:");
        parkingLot.getAvailableSpotCount().forEach((size, count) -> 
            System.out.println(size + " spots available: " + count));
        
        
        ExitGate exitGate = new ExitGate(1, new HourlyPricingStrategy(5.0));
        
        if (ticket1 != null) {
            double fee = parkingLot.removeVehicle(ticket1.getTicketId(), exitGate);
            System.out.println("\nVehicle " + car1.getLicensePlate() + " exited. Fee: $" + fee);
        }
        
        if (ticket2 != null) {
            double fee = parkingLot.removeVehicle(ticket2.getTicketId(), exitGate);
            System.out.println("Vehicle " + car2.getLicensePlate() + " exited. Fee: $" + fee);
        }
        
        System.out.println("=== Demo Complete ===");
    }
}