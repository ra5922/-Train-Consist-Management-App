package src;

import java.util.LinkedHashSet;
import java.util.Set;

public class TrainFormationApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Add duplicate intentionally
        trainFormation.add("Sleeper"); // duplicate (ignored)

        // Display final formation
        System.out.println("Final Train Formation (in insertion order):");
        System.out.println(trainFormation);

        System.out.println("\nTotal unique bogies: " + trainFormation.size());
    }
}
