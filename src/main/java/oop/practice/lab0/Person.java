package oop.practice.lab0;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private Boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits = new ArrayList<>(); // Initialize to an empty list

    public Person() {}

    public Person(int id, Boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits != null ? traits : new ArrayList<>(); // Ensure traits is not null
    }

    public int getId() { return id; }
    public Boolean isHumanoid() { return isHumanoid; }
    public String getPlanet() { return planet; }
    public int getAge() { return age; }
    public List<String> getTraits() { return traits; }

    public void setId(int id) { this.id = id; }
    public void setIsHumanoid(Boolean isHumanoid) { this.isHumanoid = isHumanoid; }
    public void setPlanet(String planet) { this.planet = planet; }
    public void setAge(int age) { this.age = age; }
    public void setTraits(List<String> traits) {
        this.traits = traits != null ? traits : new ArrayList<>(); // Ensure traits is not null
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", isHumanoid=" + isHumanoid +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                '}';
    }
}
