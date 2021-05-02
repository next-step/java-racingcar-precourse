package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("-");
    }

    @Test
    @DisplayName("random 값이 4이상이면 전진")
    void go() {
        assertThat(car.move(7)).isEqualTo("--");
    }

    @Test
    @DisplayName("random 값이 3이하이면 정지")
    void stop() {
        assertThat(car.move(3)).isEqualTo("-");
    }
}
