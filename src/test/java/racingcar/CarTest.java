package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void SCORE_계산() {
        Car car = new Car("TEST");
        car.progress(4);
        assertThat(car.getScore()).isEqualTo(1);

        car.progress(3);
        assertThat(car.getScore()).isEqualTo(1);
    }
}
