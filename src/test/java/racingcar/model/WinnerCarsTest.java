package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCarsTest {
    @Test
    @DisplayName("우승차를 조회한다.")
    void findWinnerCars() {
        Cars cars = new Cars(Arrays.asList(
                new Car("ssa", 5),
                new Car("mza", 3),
                new Car("g", 5)));
        Cars winnerCars = new Cars(Arrays.asList(
                new Car("ssa", 5),
                new Car("g", 5)));

        assertThat(cars.findWinnerCars()).isEqualTo(winnerCars);
    }
}
