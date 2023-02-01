package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @Test
    void 이동() {
        Car car = new Car("pobi");
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(new Position());
    }
}