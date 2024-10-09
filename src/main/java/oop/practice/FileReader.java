package oop.practice;

import java.io.File;

// Simple class for reading and displaying the json file using standard libraries

//import java.io.FileNotFoundException;
//import java.util.Scanner;
//public class FileReader {
//
//    private String filePath;
//
//    // Constructor
//    public FileReader(String filePath) {
//        this.filePath = filePath;
//    }
//
//    // Method to read and print the file content
//    public void readAndPrintFile() {
//        try {
//            File file = new File(filePath);
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found: " + filePath);
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        FileReader fileReader = new FileReader("src/main/resources/test-input.json");
//        fileReader.readAndPrintFile();
//    }
//}

// More Advanced class for parsing the json file using Jackson library from Maven, displaying every json object as a node

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
