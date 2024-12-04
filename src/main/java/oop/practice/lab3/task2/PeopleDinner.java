package oop.practice.lab3.task2;

public class PeopleDinner implements Dineable {
    private int count = 0;

    @Override
    public void serveDinner(int carId) {
        count++;
        System.out.println("Serving the dinner to people in car " + carId + ".");
    }

    public int getCount() {
        return count;
    }
}
