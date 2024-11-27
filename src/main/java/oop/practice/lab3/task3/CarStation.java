package oop.practice.lab3.task3;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task1.Queue;
import oop.practice.lab3.task2.*;

import java.util.HashMap;
import java.util.Map;

public class CarStation {
    private final Dineable diningService;
    private final Refuelable refuelingService;
    private final Queue<Car> queue;
    private final Map<String, Integer> statistics = new HashMap<>();
    private final String name;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue, String name) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
        this.name = name;

        // Initialize statistics
        statistics.put("CarsServed", 0);
        statistics.put("Dining", 0);
        statistics.put("NotDining", 0);
        statistics.put("TotalConsumption", 0);
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("\nAdded car to " + name + ": " + car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println("Processing car " + car.getId() + " from " + name + ".");

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
            System.out.println("Refueled car " + car.getId() + " with consumption " + car.getConsumption() + ".");

        }
    }

    public Map<String, Integer> getStatistics() {
        return statistics;
    }

    public boolean acceptsCar(Car car) {
        boolean matchesDining = (diningService instanceof PeopleDinner && "PEOPLE".equals(car.getPassengers())) ||
                (diningService instanceof RobotDinner && "ROBOTS".equals(car.getPassengers()));
        boolean matchesFuel = (refuelingService instanceof ElectricStation && "ELECTRIC".equals(car.getType())) ||
                (refuelingService instanceof GasStation && "GAS".equals(car.getType()));
        return matchesDining && matchesFuel;
    }

    public String getName() {
        return name;
    }
}
