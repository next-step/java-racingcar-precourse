package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

public class CarNamesTest {

    @DisplayName("1글자 미만인 자동차 이름이 포함됬을 경우")
    @Test
    void 한글자_미만인_자동차_이름이_포함됐을_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarNames("red,,green"))
            .withMessage(IllegalArgumentException.MSG_MIN_LENGTH_CAR_NAME);
    }

    @DisplayName("5글자를 초과한 자동차 이름이 포함됐을 경우")
    @Test
    void 다섯글자를_초과한_자동차_이름이_포함됐을_경우_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarNames("red,yellow,green"))
            .withMessage(IllegalArgumentException.MSG_MAX_LENGTH_CAR_NAME);
    }
}
