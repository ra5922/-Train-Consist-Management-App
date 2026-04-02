package src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainStreamApp {

    // Inner class for bogie details
    public static class Bogie {
        public String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    // Method to filter bogies
    public static List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("All Bogies:");
        System.out.println(bogies);

        List<Bogie> filtered = filterByCapacity(bogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        System.out.println(filtered);
    }
}