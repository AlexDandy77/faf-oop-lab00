package oop.practice.lab2.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Cappuccino(Intensity.NORMAL, 50));
        coffees.add(new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50));
        coffees.add(new Americano(Intensity.STRONG, 200));
        coffees.add(new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.VANILLA));

        for (Coffee coffee : coffees) {
            coffee.printCoffeeDetails();
            System.out.println();
        }
    }
}
