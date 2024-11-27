package oop.practice.lab2.task3;

public class SyrupCappuccino extends Coffee {
    private int mlOfMilk;
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, "Syrup Cappuccino");
        this.mlOfMilk = mlOfMilk;
        this.syrup = syrup;
    }

    public SyrupType getSyrup() { return syrup; }

    @Override
    protected void printExtraDetails() {
        System.out.println("Milk: " + mlOfMilk + " ml");
        System.out.println("Syrup type: " + syrup);
    }

    public final SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making Syrup Cappuccino");
        System.out.println("Setting intensity to " + coffeeIntensity);
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding syrup type: " + syrup);
        return this;
    }
}
