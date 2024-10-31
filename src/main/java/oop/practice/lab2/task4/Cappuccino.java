package oop.practice.lab2.task4;

public class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity, "Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() { return mlOfMilk; }

    @Override
    protected void printExtraDetails() {
        System.out.println("Milk: " + mlOfMilk + " ml");
    }

    public final Cappuccino makeCappuccino() {
        System.out.println("Making Cappuccino");
        System.out.println("Setting intensity to " + coffeeIntensity);
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        return this;
    }
}
