package racingcar.domain.winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.move.Move;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(new CarNames("우쾅쾅두둘,나의행복,나의사랑"));
    }

    @Test
    void 우승자를_가려낸다() {
        cars.move(new Move(() -> 4));
        cars.move(new Move(() -> 4));
        for (Car car : cars) {
            car.move(new Move(() -> 4));
            break;
        }

        Winner winner = new Winner(cars);

        assertThat(winner.toString()).isEqualTo("우쾅쾅두둘");
    }

    @Test
    @DisplayName("우승자를_가려낸다_(2명)")
    void winner2() {
        cars.move(new Move(() -> 4));
        cars.move(new Move(() -> 4));
        int i = 2;

        Iterator<Car> iterator = cars.iterator();
        while (i-- > 0) {
            iterator.next().move(new Move(() -> 4));
        }

        Winner winner = new Winner(cars);

        assertThat(winner.toString()).isEqualTo("우쾅쾅두둘, 나의행복");
    }
}
