package oop.practice.lab1.task4;

import java.io.File;
import java.io.IOException;

// Using Classes from task 2
import oop.practice.lab1.task2.TextData;
import oop.practice.lab1.task2.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No files provided. Please pass file paths as arguments.");
            return;
        }

        // Process each file path passed in the command-line arguments
        for (String filePath : args) {
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                continue;
            }

            String fileContent = FileReader.readFileIntoString(filePath);

            // Create a TextData object for each file and analyze it
            TextData textData = new TextData(fileContent);

            // Print the text data analysis result
            System.out.println("\nFile: " + filePath);
            System.out.println(textData);
        }
    }
}
