package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("");
    }

    @Test
    @DisplayName("GO이면 전진")
    void go() {
        car.move(GoStop.GO);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @Test
    @DisplayName("STOP이면 정지")
    void stop() {
        car.move(GoStop.STOP);
        assertThat(car.getPosition()).isEqualTo("");
    }
}
