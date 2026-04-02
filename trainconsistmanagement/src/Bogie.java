package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bogie {

    // Inner class to represent each bogie
    static class BogieDetails {
        String name;
        int capacity;

        // Constructor
        BogieDetails(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // For printing
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies
        List<BogieDetails> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new BogieDetails("Sleeper", 72));
        bogies.add(new BogieDetails("AC Chair", 54));
        bogies.add(new BogieDetails("First Class", 24));

        // Before sorting
        System.out.println("Before Sorting:");
        System.out.println(bogies);

        // Sort by capacity
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // After sorting
        System.out.println("\nAfter Sorting (by capacity):");
        System.out.println(bogies);

        System.out.println("\nSystem ready for planning and analysis.");
    }
}