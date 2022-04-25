package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    private static final String CARNAME_EMPTY_ERROR_MESSAGE = "자동차 이름은 필수값입니다. ";
    private static final String CARNAME_LENGTH_ERROR_MESSAGE = "자동차 이름의 길이는 공백 제외 1이상 5이하여야 한다. ";
    private static final String CARNAME_INVALID_ERROR_MESSAGE = "자동차 이름은 문자로만 이루어져야 한다.";

    @Test
    @DisplayName("자동차 이름의 길이가 5자를 넘어서면 에러를 던진다.")
    void throw_error_name_with_over_5() {
        String givenText = "abcdef";
        assertThatThrownBy(
            () -> new CarName(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(CARNAME_LENGTH_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름의 길이가 1자보다 작으면 에러를 던진다.")
    void throw_error_name_with_less_1(String givenText) {
        assertThatThrownBy(
            () ->new CarName(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(CARNAME_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12a"})
    @DisplayName("자동차 이름이 문자가 아닐 경우 에러를 던진다.")
    void throw_error_name_with_not_alpha(String givenText) {
        assertThatThrownBy(
            () -> new CarName(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(CARNAME_INVALID_ERROR_MESSAGE);
    }
}
