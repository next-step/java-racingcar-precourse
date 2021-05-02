package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car(1);
    }

    @Test
    void go() {
        assertThat(car.move(7)).isEqualTo(2);
    }

    @Test
    void stop() {
        assertThat(car.move(3)).isEqualTo(1);
    }
}
