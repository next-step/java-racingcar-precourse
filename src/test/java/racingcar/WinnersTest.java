package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.winner.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnersTest {

    @Test
    void WinnerTest() {

        List<Car> cars = new ArrayList<>();

        Car car1 = Car.of("test1", () -> true);
        Car car2 = Car.of("test2", () -> true);
        Car car3 = Car.of("test3", () -> false);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for (Car car : cars) {
            car.forward();
        }

        Winners winners = Winners.of(cars);
        assertThat(winners.winners()).isEqualTo("test1,test2");

    }
}