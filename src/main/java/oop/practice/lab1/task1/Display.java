package oop.practice.lab1.task1;

public class Display {
    // Attributes
    private double width;
    private double height;
    private int ppi;
    private String model;

    // Constructor
    public Display(double width, double height, int ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public int getPpi() { return ppi; }
    public String getModel() { return model; }

    // Compare size method
    public String compareSize(Display m) {
        double thisSize = this.width * this.height;
        double otherSize = m.getWidth() * m.getHeight();

        if (thisSize > otherSize) {
            return this.model + " is larger than " + m.getModel();
        } else if (thisSize < otherSize) {
            return this.model + " is smaller than " + m.getModel();
        } else {
            return this.model + " and " + m.getModel() + " are the same size.";
        }
    }

    // Compare sharpness method
    public String compareSharpness(Display m) {
        if (this.ppi > m.getPpi()) {
            return this.model + " is sharper than " + m.getModel();
        } else if (this.ppi < m.getPpi()) {
            return this.model + " is less sharp than " + m.getModel();
        } else {
            return this.model + " and " + m.getModel() + " have the same sharpness.";
        }
    }

    // Combined comparison method for both size and sharpness
    public String compareWithMonitor(Display m) {
        return compareSize(m) + "\n" + compareSharpness(m);
    }
}
