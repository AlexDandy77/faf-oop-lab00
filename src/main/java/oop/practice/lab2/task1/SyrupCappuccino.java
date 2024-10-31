package oop.practice.lab2.task1;

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
}
