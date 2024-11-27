package oop.practice.lab3.task2;

public class RobotDinner implements Dineable{
    private int count = 0;

    @Override
    public void serveDinner(int carId) {
        count++;
        System.out.println("Serving dinner to robots in car " + carId + ".");
    }

    public int getCount() {
        return count;
    }
}
