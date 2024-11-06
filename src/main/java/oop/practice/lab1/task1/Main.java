package oop.practice.lab1.task1;

public class Main {
    public static void main(String[] args) {
        // Create display objects
        Display iMac = new Display(25.6, 14.4, 218, "iMac 2024 M3");
        Display MacBookPro = new Display(13.4, 8.3, 254, "MacBook Pro M3 Pro");
        Display MacBookAir = new Display(11.3, 7.1, 224, "MacBook Air M3");

        // Compare displays
        System.out.println(iMac.compareWithMonitor(MacBookPro));
        System.out.println(MacBookPro.compareWithMonitor(MacBookAir));
        System.out.println(iMac.compareWithMonitor(MacBookAir));
    }
}
