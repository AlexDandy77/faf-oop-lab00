package oop.practice.lab2.task4;

import java.util.List;

public class Barista {

    public void makeCoffees(List<Coffee> coffeeOrders) {
        for (Coffee coffee : coffeeOrders) {
            prepareCoffee(coffee);
            System.out.println();
        }
    }

    private void prepareCoffee(Coffee coffee) {
        switch (coffee) {
            case Cappuccino cappuccino -> cappuccino.makeCappuccino();
            case PumpkinSpiceLatte pumpkinSpiceLatte -> pumpkinSpiceLatte.makePumpkinSpiceLatte();
            case Americano americano -> americano.makeAmericano();
            case SyrupCappuccino syrupCappuccino -> syrupCappuccino.makeSyrupCappuccino();
            case null, default -> System.out.println("Unknown coffee type.");
        }
    }
}
