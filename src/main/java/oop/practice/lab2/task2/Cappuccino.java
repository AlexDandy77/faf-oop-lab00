package oop.practice.lab2.task2;

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
}
