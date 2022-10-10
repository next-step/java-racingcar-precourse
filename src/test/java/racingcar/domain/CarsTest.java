package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void getWinnerTest() {
        Car dong = new Car(new CarName("dong"), 3);
        Car dd = new Car(new CarName("dd"), 2);
        Cars cars = new Cars(Arrays.asList(dong, dd));
        assertThat(cars.getWinners()).containsExactly(dong);
    }

}