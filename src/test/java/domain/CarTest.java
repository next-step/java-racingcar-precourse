package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 전진 여부 확인 테스트")
    void advance() {
        Car car = new Car("test");
        int previousAdvanceNumber = car.getAdvanceNumber();

        car.advance();

        Assertions.assertThat(car.getAdvanceNumber()).isEqualTo(previousAdvanceNumber + 1);
    }

    @Test
    @DisplayName("자동차 상태 확인 테스트")
    void getStatus() {
        Car car = new Car("test");

        car.advance();

        Assertions.assertThat(car.getStatus()).isEqualTo("-".repeat(1));
    }
}