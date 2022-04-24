package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    public void get_winner_test() {
        Car first = new Car("aaa", 55);
        Car second = new Car("bbb", 22);
        Car third = new Car("ccc", 10);

        List<Car> racingCars = Arrays.asList(first, second, third);
        Cars cars = new Cars(racingCars);
        assertThat(cars.getWinner()).containsExactly(first);
    }
}
