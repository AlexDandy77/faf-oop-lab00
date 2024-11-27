package oop.practice.lab2.task2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity, "Americano");
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() { return mlOfWater; }

    @Override
    protected void printExtraDetails() {
        System.out.println("Water: " + mlOfWater + " ml");
    }
}
