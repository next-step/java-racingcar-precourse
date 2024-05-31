import model.Car;
import model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private List<Car> cars;
    private Race race;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        race = new Race(cars, 5);
    }

    @Test
    public void raceShouldHaveCorrectNumberOfCars() {
        assertThat(race.getCars()).hasSize(3);
    }

    @Test
    public void raceShouldIdentifyWinnersCorrectly() {
        cars.get(0).move(4); // pobi moves 1 step
        cars.get(1).move(3); // woni does not move
        cars.get(2).move(5); // jun moves 1 step

        List<Car> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(2));
    }

    @Test
    public void raceShouldStartAndMoveCars() {
        race.startRace();
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }
}
