import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import model.Car;
import model.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    @DisplayName("레이스 우승자 결과 테스트")
    void raceWinnerTest() {
        ArrayList<Car> cars = new ArrayList<Car>() {{
            add(new Car("car1"));
            add(new Car("car2"));
        }};
        Race race = new Race(cars, 10);
        race.start();

        assertThat(race.getWinner().size()).isNotZero();
    }
}
