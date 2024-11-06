package oop.practice.lab0;

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
        File inputFile = new File("src/main/resources/lab0/input.json");

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

        View view = new View();

        // Write JSON to files
        view.writeJsonToFile(new Universe("Marvel", marvel), "src/main/resources/lab0/output/marvel.json");
        view.writeJsonToFile(new Universe("Star Wars", starWars), "src/main/resources/lab0/output/starwars.json");
        view.writeJsonToFile(new Universe("Hitchhiker", hitchHiker), "src/main/resources/lab0/output/hitchhiker.json");
        view.writeJsonToFile(new Universe("Lord of the Rings", rings), "src/main/resources/lab0/output/rings.json");

        // Write JSON string to console
        String marvelJsonString = view.writeJsonToString(new Universe("Marvel", marvel));
        System.out.println(marvelJsonString);

        String starwarsJsonString = view.writeJsonToString(new Universe("Star Wars", starWars));
        System.out.println(starwarsJsonString);

        String hitchhikerJsonString = view.writeJsonToString(new Universe("Hitchhiker", hitchHiker));
        System.out.println(hitchhikerJsonString);

        String lordofringsJsonString = view.writeJsonToString(new Universe("Lord of the Rings", rings));
        System.out.println(lordofringsJsonString);
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
