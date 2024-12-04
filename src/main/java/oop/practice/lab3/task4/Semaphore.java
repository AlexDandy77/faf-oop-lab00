package oop.practice.lab3.task4;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task3.CarStation;

import java.util.List;

public class Semaphore {
    private final List<CarStation> stations;

    public Semaphore(List<CarStation> stations) {
        this.stations = stations;
    }

    public void routeCar(Car car) {
        for (CarStation station : stations) {
            if (station.acceptsCar(car)) {
                station.addCar(car);
                station.serveCars();
                return;
            }
        }
        throw new IllegalArgumentException("No CarStation found for car: " + car);
    }
}
