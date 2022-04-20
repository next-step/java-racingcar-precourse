package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 앞으로 가기")
    void move_car(){
        Car car = new Car();
        assertThat(car.move()).isEqualTo(1);
    }
}
