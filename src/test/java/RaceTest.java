// RaceTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class RaceTest {
    @Test
    void testRun() {
        String[] carNames = {"car1", "car2", "car3"};
        Race race = new Race(carNames);
        race.run(5);
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            assertEquals(true, car.getPosition() <= 5);
        }
    }

    @Test
    void testGetWinners() {
        Race race = new Race(new String[]{"car1", "car2", "car3"});
        List<String> winners = race.getWinners();
        assertEquals(3, winners.size());
    }
}
