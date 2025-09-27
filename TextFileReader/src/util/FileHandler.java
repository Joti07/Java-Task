package util;

import model.Operation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileHandler {

    // Read text file -> List<Operation>
    public static List<Operation> readOperationsFromTextFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .map(FileHandler::parseLineToOperation)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private static Operation parseLineToOperation(String line) {
        try {
            String[] parts = line.split(" ");
            if (parts.length != 3) return null;
            double numOne = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double numTwo = Double.parseDouble(parts[2]);
            return new Operation(numOne, numTwo, operator);
        } catch (Exception e) {
            System.err.println("Skipping invalid line: " + line);
            return null;
        }
    }

    // Write operations to JSON-like file manually
    public static void writeOperationsToJsonFile(String filePath, List<Operation> operations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("[\n");
            for (int i = 0; i < operations.size(); i++) {
                Operation op = operations.get(i);
                writer.write("  {\n");
                writer.write("    \"numOne\": " + op.getNumOne() + ",\n");
                writer.write("    \"numTwo\": " + op.getNumTwo() + ",\n");
                writer.write("    \"operator\": \"" + op.getOperator() + "\",\n");
                writer.write("    \"result\": " + op.getResult() + "\n");
                writer.write("  }" + (i < operations.size() - 1 ? "," : "") + "\n");
            }
            writer.write("]\n");
        } catch (IOException e) {
            System.err.println("Error writing JSON file: " + e.getMessage());
        }
    }

    // Read operations from JSON-like file manually
    public static List<Operation> readOperationsFromJsonFile(String filePath) {
        List<Operation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            double numOne = 0, numTwo = 0, result = 0;
            String operator = null;
            for (String line : lines) {
                line = line.trim();
                if (line.startsWith("\"numOne\"")) {
                    numOne = Double.parseDouble(line.split(":")[1].trim().replace(",", ""));
                } else if (line.startsWith("\"numTwo\"")) {
                    numTwo = Double.parseDouble(line.split(":")[1].trim().replace(",", ""));
                } else if (line.startsWith("\"operator\"")) {
                    operator = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"result\"")) {
                    result = Double.parseDouble(line.split(":")[1].trim().replace(",", ""));
                    operations.add(new Operation(numOne, numTwo, operator));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
        return operations;
    }
}
