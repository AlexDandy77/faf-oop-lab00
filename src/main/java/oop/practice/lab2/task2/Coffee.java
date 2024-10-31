package oop.practice.lab2.task2;

public abstract class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public Intensity getCoffeeIntensity() { return coffeeIntensity; }
    public String getName() { return name; }

    // Common coffee details
    public void printCoffeeDetails() {
        System.out.println("Coffee type: " + name);
        System.out.println("Intensity: " + coffeeIntensity);
        printExtraDetails();
    }

    // Unique coffee details
    protected abstract void printExtraDetails();
}
