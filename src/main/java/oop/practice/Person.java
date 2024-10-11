package oop.practice;

import java.util.List;

public class Person {
    private int id;
    private boolean isHumanoid; // Changed field name to "isHumanoid"
    private String planet;
    private int age;
    private List<String> traits;

    public Person() {}

    public Person(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isHumanoid() { return isHumanoid; }
    public void setIsHumanoid(boolean isHumanoid) { this.isHumanoid = isHumanoid; }

    public String getPlanet() { return planet; }
    public void setPlanet(String planet) { this.planet = planet; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<String> getTraits() { return traits; }
    public void setTraits(List<String> traits) { this.traits = traits; }

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
