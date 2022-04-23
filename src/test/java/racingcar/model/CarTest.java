package racingcar.model;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.type.CarName;
import racingcar.common.type.CarPosition;
import racingcar.common.validate.ValidateUtils;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private static final String DEFAULT_SOURCE = "abcdefeghijklmnop";

    @Test
    @DisplayName("자동차를 정상 생성한다.")
    void createCar() {
        // given
        final String carName = DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH);

        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 null 이면 예외가 발생한다.")
    void createCarNameNull() {
        assertThatThrownBy(() -> new Car(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.SOURCE_NULL_MSG);
    }

    @Test
    @DisplayName("자동차 이름이 너무 길면 예외가 발생한다.")
    void createCarNameLong() {
        // given
        final String carName = DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH + 1);

        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.TOO_LONG_MSG_HOLDER, carName);
    }

    @Test
    @DisplayName("랜덤이 MOVING_FORWARD 이상이면 한 칸 전진한다.")
    void moveForward() {
        // given
        final Car car = new Car(DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH));

        Assertions.assertRandomNumberInRangeTest(() -> {
                    car.moveForwardRandom();
                    car.moveForwardRandom();
                    assertThat(car.getCarPosition()).isEqualTo(1);
                },
                CarPosition.MOVING_FORWARD, CarPosition.MOVING_FORWARD - 1
        );
    }

}