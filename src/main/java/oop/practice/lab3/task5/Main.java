package oop.practice.lab3.task5;

import com.google.gson.Gson;
import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task1.SimpleQueue;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.PeopleDinner;
import oop.practice.lab3.task2.RobotDinner;
import oop.practice.lab3.task3.CarStation;
import oop.practice.lab3.task4.Semaphore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String QUEUE_DIR = "src/main/java/oop/practice/lab3/generator/queue";

    public static void main(String[] args) {
        clearQueueDirectory();
        startPythonGenerator();

        int initialCapacity = 30;
        List<CarStation> stations = createCarStations(initialCapacity);
        Semaphore semaphore = new Semaphore(stations);

        long startTime = System.currentTimeMillis();
        long duration = 60000; // 1 minute
        while (System.currentTimeMillis() - startTime < duration) {
            processNewCars(semaphore);
            try {
                Thread.sleep(4000); // Check for new cars every 4 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Step 5: Display final statistics
        System.out.println("\n=== Final Statistics ===");
        for (CarStation station : stations) {
            System.out.println("\n=== " + station.getName() + " Statistics ===");
            station.getStatistics().forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    private static void clearQueueDirectory() {
        File dir = new File(QUEUE_DIR);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        Files.delete(file.toPath());
                        System.out.println("Deleted: " + file.getName());
                    } catch (IOException e) {
                        System.err.println("Failed to delete: " + file.getName());
                    }
                }
            }
        }
        System.out.println("\nQueue directory cleared.");
    }

    private static void startPythonGenerator() {
        String pythonScript = "src/main/java/oop/practice/lab3/generator/generator.py";
        try {
            Process process = Runtime.getRuntime().exec("python " + pythonScript);
            System.out.println("Python generator started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<CarStation> createCarStations(int capacity) {
        List<CarStation> stations = new ArrayList<>();
        stations.add(new CarStation(new PeopleDinner(), new ElectricStation(), new SimpleQueue<>(capacity), "Electric People Station"));
        stations.add(new CarStation(new RobotDinner(), new ElectricStation(), new SimpleQueue<>(capacity), "Electric Robots Station"));
        stations.add(new CarStation(new PeopleDinner(), new GasStation(), new SimpleQueue<>(capacity), "Gas People Station"));
        stations.add(new CarStation(new RobotDinner(), new GasStation(), new SimpleQueue<>(capacity), "Gas Robots Station"));
        return stations;
    }

    private static void processNewCars(Semaphore semaphore) {
        File dir = new File(QUEUE_DIR);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Queue directory does not exist.");
            return;
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        if (files == null || files.length == 0) {
            System.out.println("\nNo new cars to process.");
            return;
        }

        Gson gson = new Gson();
        for (File file : files) {
            try {
                // Read and parse the car JSON file
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                Car car = gson.fromJson(content, Car.class);

                // Route and serve the car
                semaphore.routeCar(car);

                // Delete the processed file
                Files.delete(file.toPath());
                System.out.println("Processed and deleted: " + file.getName());
            } catch (IOException e) {
                System.err.println("Error processing file: " + file.getName());
            }
        }
    }
}
