package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("자동차 이름이 5글자를 초과했을 경우 에러 발생 테스트")
    @Test
    void throwsExceptionWhenOverMaxLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName("bestsilver"))
                .withMessage(CarName.MAX_LENGTH_CAR_NAME_ERROR_MSG);
    }

    @DisplayName("자동차 이름이 1글자 미만일 경우 에러 발생 테스트")
    @Test
    void throwExceptionWhenLessThenMinLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(""))
                .withMessage(CarName.MIN_LENGTH_CAR_NAME_ERROR_MSG);
    }


}

