package oop.practice.lab2.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Coffee> coffeeOrders = new ArrayList<>();
        coffeeOrders.add(new Cappuccino(Intensity.NORMAL, 50));
        coffeeOrders.add(new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50));
        coffeeOrders.add(new Americano(Intensity.STRONG, 200));
        coffeeOrders.add(new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA));

        Barista barista = new Barista();
        barista.makeCoffees(coffeeOrders);
    }
}
