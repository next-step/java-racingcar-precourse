package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

public class CarNameTest {
    @DisplayName("자동차 이름이 5글자를 초과했을 경우")
    @Test
    void 자동차_이름이_5글자_초과했을_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarName("iamsojungzzz"))
            .withMessage(IllegalArgumentException.MSG_MAX_LENGTH_CAR_NAME);
    }

    @DisplayName("자동차 이름이 1글자 미만일 경우")
    @Test
    void 자동차_이름이_1글자_미만일_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarName(""))
            .withMessage(IllegalArgumentException.MSG_MIN_LENGTH_CAR_NAME);
    }
}
