package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 전진")
    void givenNumber_shouldMoveForward() {
        Car car = new Car("tesla");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("자동차 멈춤")
    void givenNumber_shouldStop() {
        Car car = new Car("tesla");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
