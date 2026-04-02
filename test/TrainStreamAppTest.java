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
    void testReduce_TotalSeatCalculation() {
        int result = TrainStreamApp.calculateTotalCapacity(createBogies());

        assertEquals(150, result); // 72 + 54 + 24
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = TrainStreamApp.calculateTotalCapacity(createBogies());

        assertEquals(150, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainStreamApp.Bogie> list = new ArrayList<>();
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));

        int result = TrainStreamApp.calculateTotalCapacity(list);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = TrainStreamApp.calculateTotalCapacity(new ArrayList<>());

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainStreamApp.Bogie> list = createBogies();

        int result = TrainStreamApp.calculateTotalCapacity(list);

        assertEquals(150, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int result = TrainStreamApp.calculateTotalCapacity(createBogies());

        assertEquals(150, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainStreamApp.Bogie> original = createBogies();

        TrainStreamApp.calculateTotalCapacity(original);

        assertEquals(3, original.size());
    }
}