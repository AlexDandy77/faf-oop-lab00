package oop.practice.lab2.task3;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        Americano americano = new Americano(Intensity.STRONG, 200);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA);

        cappuccino.makeCappuccino();
        System.out.println();

        pumpkinSpiceLatte.makePumpkinSpiceLatte();
        System.out.println();

        americano.makeAmericano();
        System.out.println();

        syrupCappuccino.makeSyrupCappuccino();
        System.out.println();
    }
}
