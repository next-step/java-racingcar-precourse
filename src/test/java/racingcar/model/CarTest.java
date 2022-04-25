package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("forward 테스트")
    void forwardTest() {
        Car car = new Car("pobi");
        car.forward();
        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0).isLessThan(2);
    }
}
