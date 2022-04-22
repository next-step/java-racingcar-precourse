package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    void registerCars() {
        RacingCars cars = new RacingCars();
        cars.registerCars(Arrays.asList("pobi","woni","jun"));

        assertThat(cars)
                .usingRecursiveComparison()
                .isEqualTo(new RacingCars(Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"))));
    }

    @Test
    void findWinnerCars() {
        MaxScore.setMaxScore(3);

        RacingCars cars = new RacingCars(Arrays.asList(new Car("pobi", 1), new Car("woni", 3), new Car("jun", 1)));
        cars.findWinnerCars();

        assertThat(cars.getWinners()).isEqualTo("woni");
    }
}