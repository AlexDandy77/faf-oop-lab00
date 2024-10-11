package oop.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read the JSON file into a JsonNode
            File inputFile = new File("src/main/resources/test-input.json");
            JsonNode rootNode = mapper.readTree(inputFile);

            // Extract the "data" array from the root object and map it to List<Person>
            JsonNode dataNode = rootNode.get("data");
            List<Person> persons = mapper.convertValue(dataNode, new TypeReference<List<Person>>() {});

            System.out.println("\nThe list of persons as object instances:");
            // Print the list of persons
            for (Person person : persons) {
                System.out.println(person);
            }

            // Print all IDs
            System.out.println("\nAll IDs:");
            for (Person person : persons) {
                System.out.println(person.getId());
            }

            // Filter and print persons with even IDs
            List<Person> evenIds = persons.stream()
                    .filter(person -> person.getId() % 2 == 0)
                    .toList();

            System.out.println("\nPersons with even IDs:");
            for (Person person : evenIds) {
                System.out.println(person);
            }

            // Filter and print persons with odd IDs
            List<Person> oddIds = persons.stream()
                    .filter(person -> person.getId() % 2 != 0)
                    .toList();

            System.out.println("\nPersons with odd IDs:");
            for (Person person : oddIds) {
                System.out.println(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
