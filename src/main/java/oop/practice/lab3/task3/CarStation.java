package oop.practice.lab3.task3;

import oop.practice.lab3.task1.Queue;
import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.Dineable;
import oop.practice.lab3.task2.Refuelable;

import java.util.HashMap;
import java.util.Map;

public class CarStation {
    private final Dineable diningService;
    private final Refuelable refuelingService;
    private final Queue<Car> queue;
    private final Map<String, Integer> statistics = new HashMap<>();

    // Constructor with Dependency Injection
    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;

        // Initialize statistics
        statistics.put("CarsServed", 0);
        statistics.put("Dining", 0);
        statistics.put("NotDining", 0);
        statistics.put("TotalConsumption", 0);
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Added car to queue: " + car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println("\nServing car: " + car);

            // Update statistics
            statistics.put("CarsServed", statistics.get("CarsServed") + 1);
            if (car.isDining()) {
                statistics.put("Dining", statistics.get("Dining") + 1);
                diningService.serveDinner(car.getId());
            } else {
                statistics.put("NotDining", statistics.get("NotDining") + 1);
            }
            statistics.put("TotalConsumption", statistics.get("TotalConsumption") + car.getConsumption());

            // Refuel the car
            refuelingService.refuel(car.getId());
        }
    }

    public Map<String, Integer> getStatistics() {
        return statistics;
    }
}
