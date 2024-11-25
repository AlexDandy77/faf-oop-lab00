package oop.practice.lab3.task1;

public class Car {
    private int id;
    private String type;

    public Car(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + ", type='" + type + "'}";
    }
}
