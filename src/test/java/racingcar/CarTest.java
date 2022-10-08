package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.createCar("A");
    }

    @Test
    void move() {
        boolean result = car.matchCarDistance(4);
        assertThat(result).isTrue();
    }

    @Test
    void stop() {
        boolean result = car.matchCarDistance(2);
        assertThat(result).isFalse();
    }

}
