package oop.practice.lab3.task2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import oop.practice.lab3.task1.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessJsonTest {

    private static final String QUEUE_DIR = "src/main/java/oop/practice/lab3/generator/queue";

    @Test
    void processJsonFiles() {
        // Statistics map
        Map<String, Integer> stats = new HashMap<>();
        stats.put("ELECTRIC", 0);
        stats.put("GAS", 0);
        stats.put("PEOPLE", 0);
        stats.put("ROBOTS", 0);
        stats.put("DINING", 0);
        stats.put("NOT_DINING", 0);

        Map<String, Integer> consumption = new HashMap<>();
        consumption.put("ELECTRIC", 0);
        consumption.put("GAS", 0);

        Gson gson = new Gson();

        // Read all JSON files in the directory
        File dir = new File(QUEUE_DIR);
        assertTrue(dir.exists() && dir.isDirectory(), "Queue directory does not exist.");

        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        assertNotNull(files, "No JSON files found in the queue directory.");

        for (File file : files) {
            try {
                // Read file content
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));

                // Parse JSON to Car object
                Car car = gson.fromJson(content, Car.class);

                // Update stats
                stats.put(car.getType(), stats.get(car.getType()) + 1);
                stats.put(car.getPassengers(), stats.get(car.getPassengers()) + 1);

                if (car.isDining()) {
                    stats.put("DINING", stats.get("DINING") + 1);
                } else {
                    stats.put("NOT_DINING", stats.get("NOT_DINING") + 1);
                }

                consumption.put(car.getType(), consumption.get(car.getType()) + car.getConsumption());

            } catch (IOException | JsonSyntaxException e) {
                fail("Failed to process file: " + file.getName() + " - " + e.getMessage());
            }
        }

        // Print statistics
        System.out.println("=== Final Statistics ===");
        stats.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("Consumption:");
        consumption.forEach((key, value) -> System.out.println(key + ": " + value));

        // Assert that stats are non-zero (optional check)
        assertTrue(stats.values().stream().anyMatch(v -> v > 0), "Statistics should not be empty.");
    }
}
