package src;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display after adding
        System.out.println("Passenger bogies added:");
        System.out.println("Current train consist: " + passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing AC Chair:");
        System.out.println("Current train consist: " + passengerBogies);

        // Check existence of Sleeper
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper exist? " + exists);

        // Final state
        System.out.println("\nFinal train consist: " + passengerBogies);

        System.out.println("System is ready for further operations.");
    }
}