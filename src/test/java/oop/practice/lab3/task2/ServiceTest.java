package oop.practice.lab3.task2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnifiedServiceTest {

    // Counters for statistics
    private static int peopleServed = 0;
    private static int robotsServed = 0;
    private static int electricCarsRefueled = 0;
    private static int gasCarsRefueled = 0;

    @Test
    void testPeopleDinner() {
        PeopleDinner peopleDinner = new PeopleDinner();

        // Serve dinner to 2 cars
        peopleDinner.serveDinner("Car1");
        peopleDinner.serveDinner("Car2");

        // Update statistics
        peopleServed += peopleDinner.getCount();

        // Assertions
        assertEquals(2, peopleDinner.getCount(), "PeopleDinner should have served 2 cars.");
    }

    @Test
    void testRobotDinner() {
        RobotDinner robotDinner = new RobotDinner();

        // Serve dinner to 1 car
        robotDinner.serveDinner("Car3");

        // Update statistics
        robotsServed += robotDinner.getCount();

        // Assertions
        assertEquals(1, robotDinner.getCount(), "RobotDinner should have served 1 car.");
    }

    @Test
    void testElectricStation() {
        ElectricStation electricStation = new ElectricStation();

        // Refuel 3 electric cars
        electricStation.refuel("Car4");
        electricStation.refuel("Car5");
        electricStation.refuel("Car6");

        // Update statistics
        electricCarsRefueled += electricStation.getCount();

        // Assertions
        assertEquals(3, electricStation.getCount(), "ElectricStation should have refueled 3 cars.");
    }

    @Test
    void testGasStation() {
        GasStation gasStation = new GasStation();

        // Refuel 2 gas cars
        gasStation.refuel("Car7");
        gasStation.refuel("Car8");

        // Update statistics
        gasCarsRefueled += gasStation.getCount();

        // Assertions
        assertEquals(2, gasStation.getCount(), "GasStation should have refueled 2 cars.");
    }

    @AfterAll
    static void showStatistics() {
        // Print consolidated statistics after all tests
        System.out.println("\n=== Consolidated Service Statistics ===");
        System.out.println("People served dinner: " + peopleServed);
        System.out.println("Robots served dinner: " + robotsServed);
        System.out.println("Electric cars refueled: " + electricCarsRefueled);
        System.out.println("Gas cars refueled: " + gasCarsRefueled);
        System.out.println("Total cars served: " + (peopleServed + robotsServed + electricCarsRefueled + gasCarsRefueled));
    }
}
