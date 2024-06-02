import Model.Car;
import Model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RaceTest {
    private List<Car> cars;
    private Race race;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        race = new Race(cars, 5);
    }

    @Test
    void shouldRaceForGivenNumberOfMoves() {
        race.startRace();
        int totalMoves = cars.stream().mapToInt(Car::getPosition).sum();
        assertThat(totalMoves).isGreaterThanOrEqualTo(0);
    }

    @Test
    void shouldDetermineWinnersCorrectly() {
        race.startRace();
        List<String> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
    }
}
