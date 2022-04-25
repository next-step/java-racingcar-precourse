package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNamesTest {

    @DisplayName("1글자 미만인 자동차 이름이 포함됬을 경우 에러 발생 테스트")
    @Test
    void throwExceptionWhenContainsCarNameLessThanMinLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarNames("red,,green"))
                .withMessage(CarName.MIN_LENGTH_CAR_NAME_ERROR_MSG);
    }

    @DisplayName("5글자를 초과인 자동차 이름이 포함됬을 경우 에러 발생 테스트")
    @Test
    void throwExceptionWhenContainsCarNameOverMaxLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarNames("red,yellow,green"))
                .withMessage(CarName.MAX_LENGTH_CAR_NAME_ERROR_MSG);
    }

}
