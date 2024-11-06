package oop.practice.lab1.task3;

import java.util.ArrayList;
import java.util.List;

// Reusing Display Class from Task 1
import oop.practice.lab1.task1.Display;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
        System.out.println(assistantName + " is assisting with display comparison:");

        // Sequentially compare the displays in the list
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display current = assignedDisplays.get(i);
            Display next = assignedDisplays.get(i + 1);

            System.out.println("\nComparing " + current.getModel() + " with " + next.getModel() + ":");
            System.out.println(current.compareWithMonitor(next));
        }
    }

    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("Bought: " + d.getModel());
            return d;
        } else {
            System.out.println("Display not found.");
            return null;
        }
    }

    public void printRemainingDisplays() {
        System.out.println("\nRemaining Displays:");
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays left.");
        } else {
            for (Display d : assignedDisplays) {
                System.out.println(d.getModel() + " - Size: " + d.getWidth() + " x " + d.getHeight() + ", PPI: " + d.getPpi());
            }
        }
    }
}
