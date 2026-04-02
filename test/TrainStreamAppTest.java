import org.junit.jupiter.api.Test;
import src.TrainStreamApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrainStreamAppTest {

    // Helper method
    private List<TrainStreamApp.Bogie> createBogies() {
        List<TrainStreamApp.Bogie> list = new ArrayList<>();
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));
        list.add(new TrainStreamApp.Bogie("AC Chair", 54));
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));
        list.add(new TrainStreamApp.Bogie("First Class", 24));
        list.add(new TrainStreamApp.Bogie("AC Chair", 54));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(createBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(createBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(createBogies());

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainStreamApp.Bogie> list = new ArrayList<>();
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));
        list.add(new TrainStreamApp.Bogie("Sleeper", 72));

        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(list);

        assertEquals(1, result.size());
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(createBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<TrainStreamApp.Bogie>> result =
                TrainStreamApp.groupBogiesByType(createBogies());

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainStreamApp.Bogie> original = createBogies();

        TrainStreamApp.groupBogiesByType(original);

        assertEquals(5, original.size());
    }
}