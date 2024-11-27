package oop.practice.lab3.task2;

public class ElectricStation implements Refuelable{
    private int count = 0;

    @Override
    public void refuel(int carId) {
        count++;
        System.out.println("Refueling electric car " + carId + "..");
    }

    public int getCount() {
        return count;
    }
}
