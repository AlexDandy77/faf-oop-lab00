package oop.practice.lab2.task2;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, "Pumpkin Spice Latte");
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMlOfMilk() { return mlOfMilk; }
    public int getMgOfPumpkinSpice() { return mgOfPumpkinSpice; }

    @Override
    protected void printExtraDetails() {
        System.out.println("Milk: " + mlOfMilk + " ml");
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }
}
