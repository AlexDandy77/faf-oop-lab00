package oop.practice.lab2.task4;

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

    public final Americano makeAmericano() {
        System.out.println("Making Americano");
        System.out.println("Setting intensity to " + coffeeIntensity);
        System.out.println("Adding " + mlOfWater + " ml of water");
        return this;
    }
}
