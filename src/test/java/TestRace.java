import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestRace {

    private Race race;
    private Car[] cars;

    @BeforeEach
    public void setUp() {
        race = new Race();
        cars = new Car[] {
            new Car("Car1", 0),
            new Car("Car2", 0),
            new Car("Car3", 0)
        };
    }

    @Test
    public void testRandGen() {
        int randValue = race.randGen();
        assertTrue(randValue >= 0 && randValue < 10);
    }

    @Test
    public void testCheckNum() {
        assertTrue(race.checkNum(4));
        assertTrue(race.checkNum(10));
        assertFalse(race.checkNum(3));
        assertFalse(race.checkNum(0));
    }

    @Test
    public void testCheckGo() {
        assertEquals(1, race.checkGo(true));
        assertEquals(0, race.checkGo(false));
    }

    @Test
    public void testFindMaxDistance() {
        cars[0].setDistance(5);
        cars[1].setDistance(10);
        cars[2].setDistance(3);

        assertEquals(10, race.findMaxDistance(cars));
    }

    @Test
    public void testReturnWinner() {
        cars[0].setDistance(5);
        cars[1].setDistance(10);
        cars[2].setDistance(10);

        String[] winners = race.returnWinner(cars);
        assertArrayEquals(new String[] {"Car2", "Car3"}, winners);
    }
}
