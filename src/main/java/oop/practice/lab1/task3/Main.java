package oop.practice.lab1.task3;

// Reusing Display Class from Task 1
import oop.practice.lab1.task1.Display;

public class Main {
    public static void main(String[] args) {
        // Creating Display objects
        Display display1 = new Display(27.0, 15.0, 218, "iMac 2024");
        Display display2 = new Display(16.0, 10.0, 250, "MacBook Pro M3 Pro");
        Display display3 = new Display(13.3, 8.0, 227, "MacBook Air M3");

        // Assistant object
        Assistant assistant = new Assistant("John");

        // Assign displays to assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        // Assist with comparing displays
        assistant.assist();

        // Buy a display
        assistant.buyDisplay(display2);

        // Print remaining displays
        assistant.printRemainingDisplays();

    }
}
