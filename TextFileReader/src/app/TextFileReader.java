package app;

import model.Operation;
import util.FileHandler;

import java.util.List;

public class TextFileReader {
    public static void main(String[] args) {
        String inputFile = "input.txt";     // Input text file
        String outputFile = "output.json";  // Output JSON file

        // Read text file -> List<Operation>
        List<Operation> operations = FileHandler.readOperationsFromTextFile(inputFile);

        // Save as JSON
        FileHandler.writeOperationsToJsonFile(outputFile, operations);

        // Read JSON -> List<Operation> -> Print
        FileHandler.readOperationsFromJsonFile(outputFile)
                .stream()
                .forEach(System.out::println);
    }
}
