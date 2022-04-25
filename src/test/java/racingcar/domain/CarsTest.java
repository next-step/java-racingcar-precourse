package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 경주 우승자 찾기")
    void givenCars_shouldWinner() {
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(1));
        Car honux = new Car("honux", new Position(2));
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
        assertThat(cars.getWinners()).contains(pobi);
    }

    @Test
    @DisplayName("자동차 경주 우승자 여러명 찾기")
    void givenCars_shouldMultipleWinner() {
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(1));
        Car honux = new Car("honux", new Position(3));
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
        assertThat(cars.getWinners()).contains(pobi, honux);
    }
}
