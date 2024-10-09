package oop.practice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a Person instance
        Person person = new Person(1, true, "Earth", 30, Arrays.asList("Smart", "Strong"));

        // Print the person's details
        System.out.println(person);

        // Modify the person's details
        person.setAge(31);
        person.setTraits(Arrays.asList("Smart", "Strong", "Brave"));

        // Print the modified person's details
        System.out.println("After modification: " + person);
    }
}
