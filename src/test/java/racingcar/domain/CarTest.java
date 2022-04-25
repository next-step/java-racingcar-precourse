package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 멈춘다() {
        Car car = new Car(new CarName("car"), new Position(0));
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car(new CarName("car"), new Position(0)));
    }

    @Test
    void 이동한다() {
        Car car = new Car(new CarName("car"), new Position(0));
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car(new CarName("car"), new Position(1)));
    }
}
