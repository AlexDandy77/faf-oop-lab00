package oop.practice.lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Ensure file path is provided as a program argument
        if (args.length < 1) {
            System.out.println("Please provide a file path as an argument.");
            return;
        }

        String filePath = args[0];

        try {
            // Read file
            String fileContent = FileReader.readFileIntoString(filePath);

            // Analyze text
            TextData textData = new TextData(fileContent);

            // Print the results
            System.out.println(textData);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
