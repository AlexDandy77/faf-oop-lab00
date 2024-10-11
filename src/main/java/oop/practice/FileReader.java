package oop.practice;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FileReader {

    private String filePath;

    // Constructor
    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    // Method to read and parse the JSON file
    public void readAndParseJsonFile() {
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();
            // Read and parse the JSON file
            JsonNode jsonNode = mapper.readTree(new File(filePath));

            // Print the entire parsed JSON structure
            System.out.println("Parsed JSON: " + jsonNode.toString());

            // Print each individual node
            for (JsonNode node : jsonNode.get("data")) {
                System.out.println("Individual JSON object: " + node.toString());
            }
        } catch (IOException e) {
            System.err.println("Error reading or parsing the file: " + filePath);
            e.printStackTrace();
        }
    }
}
