import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    @Test
    public void testGetWinnersWithSingleWinner() {
        // Arrange
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        Race race = new Race(carNames, 3);

        // Act
        race.start();
        List<Car> winners = race.getWinners();

        // Assert
        assertEquals(1, winners.size());
        assertEquals(3, winners.get(0).getPosition());
    }

    @Test
    public void testGetWinnersWithMultipleWinners() {
        // Arrange
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        Race race = new Race(carNames, 5);

        // Act
        race.start();
        List<Car> winners = race.getWinners();

        // Assert
        assertEquals(3, winners.size());
        assertEquals(5, winners.get(0).getPosition());
        assertEquals(5, winners.get(1).getPosition());
        assertEquals(5, winners.get(2).getPosition());
    }

    @Test
    public void testGetWinnersWithNoWinner() {
        // Arrange
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        Race race = new Race(carNames, 0);

        // Act
        race.start();
        List<Car> winners = race.getWinners();

        // Assert
        assertEquals(0, winners.size());
    }
}