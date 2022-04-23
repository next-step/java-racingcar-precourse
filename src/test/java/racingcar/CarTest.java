package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    void init() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void validateName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("pobiii"));
    }

    @Test
    void go() {
        Car car = new Car();
        car.go(3);
        car.go(4);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
