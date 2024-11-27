package oop.practice.lab3.task2;

public class GasStation implements Refuelable {
    private int count = 0;

    @Override
    public void refuel(int carId) {
        count++;
        System.out.println("Refueling gas car " + carId + ".");
    }

    public int getCount() {
        return count;
    }
}
