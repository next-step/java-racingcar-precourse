package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceResultAnalyzerTest {
    private RaceResultAnalyzer analyzer;

    @BeforeEach
    public void setUp() {
        analyzer = new RaceResultAnalyzer();
    }

    @Test
    public void testSingleWinner() {
        HashMap<String, String> result = new HashMap<>();
        result.put("CarA", "--");
        result.put("CarB", "-");
        result.put("CarC", "---");

        Set<String> winners = analyzer.compareRaceCar(result);
        assertEquals(Set.of("CarC"), winners);
    }

    @Test
    public void testMultipleWinners() {
        HashMap<String, String> result = new HashMap<>();
        result.put("CarA", "--");
        result.put("CarB", "--");
        result.put("CarC", "-");

        Set<String> winners = analyzer.compareRaceCar(result);
        assertEquals(Set.of("CarA", "CarB"), winners);
    }

    @Test
    public void testAll() {
        HashMap<String, String> result = new HashMap<>();
        result.put("CarA", "--");
        result.put("CarB", "--");
        result.put("CarC", "--");

        Set<String> winners = analyzer.compareRaceCar(result);
        assertEquals(Set.of("CarA", "CarB", "CarC"), winners);
    }

    @Test
    public void testNoCars() {
        HashMap<String, String> result = new HashMap<>();

        Set<String> winners = analyzer.compareRaceCar(result);
        assertEquals(Set.of(), winners);
    }
}
