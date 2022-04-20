package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void go() {
        Car car = new Car();
        car.go(3);
        car.go(4);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
