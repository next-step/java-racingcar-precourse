package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.rule.GoStop.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_전진_또는_멈춤_한다() {
        Car car = new Car("test");
        car.goOrStop(GO);
        assertThat(car.getDistance().get()).isEqualTo(1);
        car.goOrStop(STOP);
        assertThat(car.getDistance().get()).isEqualTo(1);
        car.goOrStop(GO);
        assertThat(car.getDistance().get()).isEqualTo(2);
        car.goOrStop(STOP);
        assertThat(car.getDistance().get()).isEqualTo(2);
    }
}
