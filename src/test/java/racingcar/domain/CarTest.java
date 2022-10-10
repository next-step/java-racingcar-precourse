package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.type.ErrorMessageType.NOT_ALLOW_GREATER_THAN_FIVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    void allowCarNameLengthLessThanFive() {
        Car car = new Car("crong");
        car.validateCarNameLength();
        assertThat(car.getName()).isEqualTo("crong");
    }

    @Test
    @DisplayName("자동차 이름은 5자 보다 크다면 IllegalArgumentException 예외가 발생한다.")
    void notAllowCarNameLengthGreaterThanFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Car car = new Car("woowabrie");
                    car.validateCarNameLength();
                })
                .withMessageContaining(NOT_ALLOW_GREATER_THAN_FIVE.getMessage());
    }

    @Test
    @DisplayName("자동차가 전진한다.")
    void carMovingForward() {
        Car car = new Car("pobi");
        assertThat(car.getMovingCount()).isEqualTo(0);
        car.movingForward();
        assertThat(car.getMovingCount()).isEqualTo(1);
    }

}