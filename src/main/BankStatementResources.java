package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class BankStatementResources {

    private static final String RESOURCES = "src/main/resources.csv";

    public BankStatementResources() {
    }

    public static String getRESOURCES() {
        return RESOURCES;
    }

    public static List<String> getResourcesLinesList() {
        try {
            String RESOURCES = getRESOURCES();
            final Path path = Paths.get(RESOURCES);
            final List<String> lines = Files.readAllLines(path);

            return lines;

        } catch (IOException e) {
            System.out.println("Error, file not found");

            return Collections.<String>emptyList();
        }
    }

}
