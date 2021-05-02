package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    @Test
    @DisplayName("차 전진 테스트")
    void moveTest() {
        Car car = new Car();
        assertThat(car.move(4)).isTrue();
        assertThat(car.move(3)).isFalse();
    }
}
