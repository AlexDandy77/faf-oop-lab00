package oop.practice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Person instance
        Person person = new Person(1, true, "Earth", 30, Arrays.asList("Smart", "Strong"));

        // Person's details
        System.out.println(person);

        // Person's details modification
        person.setAge(31);
        person.setTraits(Arrays.asList("Smart", "Strong", "Brave"));

        // Printing the details after modification
        System.out.println("After modification: " + person);

        // Parsing test JSON file and printing data by objects
        FileReader fileReader = new FileReader("src/main/resources/test-input.json");
        fileReader.readAndParseJsonFile();
    }
}
