import org.junit.jupiter.api.Test;
import src.TrainStreamApp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainStreamAppTest {

    // Helper method
    private List<TrainStreamApp.Bogie> createBogies() {
        List<TrainStreamApp.Bogie> list = new ArrayList<>();
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));
        list.add(new TrainStreamApp.Bogie("AC Chair", 54));
        list.add(new TrainStreamApp.Bogie("First Class", 24));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(createBogies(), 60);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(createBogies(), 72);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(createBogies(), 70);

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(createBogies(), 20);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(createBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainStreamApp.Bogie> result =
                TrainStreamApp.filterByCapacity(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainStreamApp.Bogie> original = createBogies();

        TrainStreamApp.filterByCapacity(original, 60);

        assertEquals(3, original.size());
    }
}