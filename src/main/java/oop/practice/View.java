package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class View {

    private ObjectMapper mapper = new ObjectMapper();  // Create the object mapper for JSON operations

    public String writeJsonToString(Universe universe) throws IOException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(universe);  // Pretty print JSON string
    }
    // Method to write the Universe object to JSON file
    public void writeJsonToFile(Universe universe, String filename) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), universe); // Pretty print the output
    }
}
