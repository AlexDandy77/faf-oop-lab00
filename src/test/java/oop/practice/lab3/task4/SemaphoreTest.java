package oop.practice.lab3.task4;

import com.google.gson.Gson;
import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task1.SimpleQueue;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.PeopleDinner;
import oop.practice.lab3.task2.RobotDinner;
import oop.practice.lab3.task3.CarStation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreTest {

    @Test
    void testSemaphoreRouting() {
        // Create CarStations
        CarStation electricPeopleStation = new CarStation(new PeopleDinner(), new ElectricStation(), new SimpleQueue<>(10));
        CarStation electricRobotsStation = new CarStation(new RobotDinner(), new ElectricStation(), new SimpleQueue<>(10));
        CarStation gasPeopleStation = new CarStation(new PeopleDinner(), new GasStation(), new SimpleQueue<>(10));
        CarStation gasRobotsStation = new CarStation(new RobotDinner(), new GasStation(), new SimpleQueue<>(10));

        // Add CarStations to a list
        List<CarStation> stations = new ArrayList<>();
        stations.add(electricPeopleStation);
        stations.add(electricRobotsStation);
        stations.add(gasPeopleStation);
        stations.add(gasRobotsStation);

        // Create Semaphore
        Semaphore semaphore = new Semaphore(stations);

        // JSON Strings
        String car1Json = "{\"id\":1,\"type\":\"ELECTRIC\",\"passengers\":\"PEOPLE\",\"isDining\":true,\"consumption\":30}";
        String car2Json = "{\"id\":2,\"type\":\"GAS\",\"passengers\":\"ROBOTS\",\"isDining\":false,\"consumption\":40}";
        String car3Json = "{\"id\":3,\"type\":\"ELECTRIC\",\"passengers\":\"ROBOTS\",\"isDining\":true,\"consumption\":20}";
        String car4Json = "{\"id\":4,\"type\":\"GAS\",\"passengers\":\"PEOPLE\",\"isDining\":false,\"consumption\":50}";

        // Parse JSON strings to Car objects
        Gson gson = new Gson();
        Car car1 = gson.fromJson(car1Json, Car.class);
        Car car2 = gson.fromJson(car2Json, Car.class);
        Car car3 = gson.fromJson(car3Json, Car.class);
        Car car4 = gson.fromJson(car4Json, Car.class);

        // Route cars
        semaphore.routeCar(car1);
        semaphore.routeCar(car2);
        semaphore.routeCar(car3);
        semaphore.routeCar(car4);

        // Serve cars
        electricPeopleStation.serveCars();
        electricRobotsStation.serveCars();
        gasPeopleStation.serveCars();
        gasRobotsStation.serveCars();

        // Verify statistics
        assertEquals(1, electricPeopleStation.getStatistics().get("CarsServed"));
        assertEquals(1, electricRobotsStation.getStatistics().get("CarsServed"));
        assertEquals(1, gasPeopleStation.getStatistics().get("CarsServed"));
        assertEquals(1, gasRobotsStation.getStatistics().get("CarsServed"));

        // Print statistics
        System.out.println("\n=== Electric People Station Statistics ===");
        electricPeopleStation.getStatistics().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n=== Electric Robots Station Statistics ===");
        electricRobotsStation.getStatistics().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n=== Gas People Station Statistics ===");
        gasPeopleStation.getStatistics().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n=== Gas Robots Station Statistics ===");
        gasRobotsStation.getStatistics().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
