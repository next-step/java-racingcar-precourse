package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 자동차_리스트_생성() {
        Cars cars = Cars.makeCars(Arrays.asList("pobi", "jun", "crong"));
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 자동차_리스트_이동() {
        Cars cars = Cars.makeCars(Arrays.asList("pobi", "jun", "crong"));
        cars.move(Arrays.asList(1, 1, 4));
        assertThat(cars.getMaxPosition()).isEqualTo(1);

        cars.move(Arrays.asList(1, 1, 4));
        assertThat(cars.getMaxPosition()).isEqualTo(2);
    }

    @Test
    void 중복된_자동차명_검사() {
        assertThrows(IllegalArgumentException.class,
                () -> Cars.makeCars(Arrays.asList("pobi", "pobi", "crong")));
    }
}