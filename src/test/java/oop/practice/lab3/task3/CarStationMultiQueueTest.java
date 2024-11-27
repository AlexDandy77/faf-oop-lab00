package oop.practice.lab3.task3;

import com.google.gson.Gson;
import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task1.SimpleQueue;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.PeopleDinner;
import oop.practice.lab3.task2.RobotDinner;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CarStationMultiQueueTest {
    private static final String QUEUE_DIR = "src/main/java/oop/practice/lab3/generator/queue";

    @Test
    void testMultiQueueCarStations() {
        // Load JSON files
        File dir = new File(QUEUE_DIR);
        assertTrue(dir.exists() && dir.isDirectory(), "Queue directory does not exist.");

        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        assertNotNull(files, "No JSON files found in the queue directory.");
        int capacity = files.length;

        CarStation electricPeopleStation = new CarStation(new PeopleDinner(), new ElectricStation(), new SimpleQueue<>(capacity), "electricPeopleStation");
        CarStation electricRobotsStation = new CarStation(new RobotDinner(), new ElectricStation(), new SimpleQueue<>(capacity), "electricRobotsStation");
        CarStation gasPeopleStation = new CarStation(new PeopleDinner(), new GasStation(), new SimpleQueue<>(capacity), "gasPeopleStation");
        CarStation gasRobotsStation = new CarStation(new RobotDinner(), new GasStation(), new SimpleQueue<>(capacity), "gasRobotsStation");

        Gson gson = new Gson();

        try {
            // Assign cars to the appropriate station
            for (File file : files) {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                Car car = gson.fromJson(content, Car.class);

                if ("ELECTRIC".equals(car.getType()) && "PEOPLE".equals(car.getPassengers())) {
                    electricPeopleStation.addCar(car);
                } else if ("ELECTRIC".equals(car.getType()) && "ROBOTS".equals(car.getPassengers())) {
                    electricRobotsStation.addCar(car);
                } else if ("GAS".equals(car.getType()) && "PEOPLE".equals(car.getPassengers())) {
                    gasPeopleStation.addCar(car);
                } else if ("GAS".equals(car.getType()) && "ROBOTS".equals(car.getPassengers())) {
                    gasRobotsStation.addCar(car);
                }
            }
        } catch (IOException e) {
            fail("Failed to read JSON files: " + e.getMessage());
        }

        // Serve cars in each station
        electricPeopleStation.serveCars();
        electricRobotsStation.serveCars();
        gasPeopleStation.serveCars();
        gasRobotsStation.serveCars();

        // Display statistics for each station
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
