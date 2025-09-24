package com.example.parking;

/*
 * SIMPLIFIED PARKING LOT SYSTEM
 * 
 * CLASS RELATIONSHIPS:
 * 
 * ParkingLot (Main Controller)
 *   ├── contains List<ParkingSpot> - Direct spot management
 *   ├── contains List<EntryGate> 
 *   ├── contains List<ExitGate>
 *   ├── uses SlotAllocationStrategy (interface)
 *   ├── manages Map<String, Ticket> - Active parking tickets
 *   └── tracks Map<SpotSize, Integer> - Available spot counts
 * 
 * ParkingSpot
 *   ├── has SpotSize enum (SMALL, MEDIUM, LARGE, ELECTRIC)
 *   ├── has spotNumber (int)
 *   └── can contain Vehicle
 * 
 * Vehicle (Simplified)
 *   ├── licensePlate (String) - Vehicle identifier
 *   └── requiredSpotSize (SpotSize) - Size requirement
 * 
 * Strategies:
 *   ├── SlotAllocationStrategy (interface)
 *   │   └── NearestSlotStrategy - First available spot
 *   └── PricingStrategy (interface)
 *       └── HourlyPricingStrategy - Time-based pricing
 * 
 * Gates & Tickets:
 *   ├── EntryGate - Generates tickets
 *   ├── ExitGate - Calculates fees using PricingStrategy
 *   └── Ticket - Entry/exit tracking with timestamps
 * 
 * SIMPLIFICATIONS MADE:
 * ✓ Removed ParkingFloor - Direct spot management
 * ✓ Removed Vehicle subclasses - Single Vehicle class with string license
 * ✓ Kept only SpotSize-based allocation
 * ✓ Maintained SOLID compliance
 * 
 * SOLID PRINCIPLES:
 * - Single Responsibility: Each class has one clear purpose
 * - Open/Closed: Easy to add new strategies
 * - Liskov Substitution: Strategy interfaces work interchangeably  
 * - Interface Segregation: Focused, minimal interfaces
 * - Dependency Inversion: Dependencies through interfaces
 */

public class SystemDesignSummary {
    // Documentation class for simplified architecture
}