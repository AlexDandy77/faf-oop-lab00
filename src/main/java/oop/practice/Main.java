package oop.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/input.json");

        // Read the entire JSON file into a JsonNode
        JsonNode rootNode = mapper.readTree(inputFile);

        // Extract the "data" node, array of persons
        JsonNode dataNode = rootNode.get("data");

        // Map the "data" node to a List of Person objects
        List<Person> persons = mapper.convertValue(dataNode, new TypeReference<List<Person>>() {});

        // Containers for classified individuals
        List<Person> starWars = new ArrayList<>();
        List<Person> marvel = new ArrayList<>();
        List<Person> hitchHiker = new ArrayList<>();
        List<Person> rings = new ArrayList<>();

        Classifier classifier = new Classifier();

        // Classify each person and add to the respective universe list
        for (Person person : persons) {
            String universe = classifier.classify(person);
            switch (universe) {
                case "Star Wars":
                    starWars.add(person);
                    break;
                case "Marvel":
                    marvel.add(person);
                    break;
                case "Hitchhiker":
                    hitchHiker.add(person);
                    break;
                case "Lord of the Rings":
                    rings.add(person);
                    break;
                default:
                    System.out.println("Person with ID " + person.getId() + " does not fit any universe.");
            }
        }

        // Write JSON to files
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/output/starwars.json"), new Universe("Star Wars", starWars));
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/output/marvel.json"), new Universe("Marvel", marvel));
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/output/hitchhiker.json"), new Universe("Hitchhiker", hitchHiker));
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/output/rings.json"), new Universe("Lord of the Rings", rings));
    }
}

class Universe {
    private String name;
    private List<Person> individuals;

    public Universe(String name, List<Person> individuals) {
        this.name = name;
        this.individuals = individuals;
    }

    public String getName() {
        return name;
    }

    public List<Person> getIndividuals() {
        return individuals;
    }
}
