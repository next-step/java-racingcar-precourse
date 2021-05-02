package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("입력된 이름으로 차 만들기")
    void createCars() {
        Cars cars = new Cars(new String[] {"pobi", "crong", "honux"});

        assertThat(cars.hasCar("pobi")).isTrue();
        assertThat(cars.hasCar("crong")).isTrue();
        assertThat(cars.hasCar("honux")).isTrue();
        assertThat(cars.hasCar("test")).isFalse();
    }
}

