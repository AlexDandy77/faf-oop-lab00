package oop.practice.lab2.task1;

public class Main {
    public static void main(String[] args) {
        // Create instances of each coffee type with sample values
        Coffee cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.STRONG, 100, 50);
        Coffee americano = new Americano(Intensity.LIGHT, 200);
        Coffee syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 50, SyrupType.CARAMEL);

        // Print properties of each coffee type
        System.out.println("Cappuccino:");
        printCoffeeDetails(cappuccino);

        System.out.println("\nPumpkin Spice Latte:");
        printCoffeeDetails(pumpkinSpiceLatte);

        System.out.println("\nAmericano:");
        printCoffeeDetails(americano);

        System.out.println("\nSyrup Cappuccino:");
        printCoffeeDetails(syrupCappuccino);
    }

    // Helper method to print details of a coffee instance
    public static void printCoffeeDetails(Coffee coffee) {
        System.out.println("Coffee Type: " + coffee.getClass().getSimpleName());
        System.out.println("Intensity: " + coffee.getCoffeeIntensity());

        if (coffee instanceof Cappuccino) {
            Cappuccino cappuccino = (Cappuccino) coffee;
            System.out.println("Milk: " + cappuccino.getMlOfMilk() + " ml");
        } else if (coffee instanceof PumpkinSpiceLatte) {
            PumpkinSpiceLatte latte = (PumpkinSpiceLatte) coffee;
            System.out.println("Milk: " + latte.getMlOfMilk() + " ml");
            System.out.println("Pumpkin Spice: " + latte.getMgOfPumpkinSpice() + " mg");
        } else if (coffee instanceof Americano) {
            Americano americano = (Americano) coffee;
            System.out.println("Water: " + americano.getMlOfWater() + " ml");
        } else if (coffee instanceof SyrupCappuccino) {
            SyrupCappuccino syrupCappuccino = (SyrupCappuccino) coffee;
            System.out.println("Milk: " + syrupCappuccino.getMlOfMilk() + " ml");
            System.out.println("Syrup Type: " + syrupCappuccino.getSyrup());
        }
    }
}
