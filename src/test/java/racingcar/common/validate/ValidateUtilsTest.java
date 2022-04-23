package racingcar.common.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.common.type.CarName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateUtilsTest {

    private static final String DEFAULT_SOURCE = "abcdefeghijklmnop";

    @Test
    @DisplayName("source 가 정상 일 때 예외가 발생하지 않아야 한다.")
    void validNormal() {
        // given
        final String source = DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH);

        assertThatCode(() -> ValidateUtils.maxLength(source, CarName.CAR_NAME_MAX_LENGTH))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("source 가 null 일 때 예외가 발생해야 한다.")
    void validNull(final String source) {
        assertThatThrownBy(() -> ValidateUtils.maxLength(source, CarName.CAR_NAME_MAX_LENGTH))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.SOURCE_NULL_MSG);
    }

    @Test
    @DisplayName("source 가 길면 예외가 발생해야 한다.")
    void validLong() {
        // given
        final String source = DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH + 1);

        assertThatThrownBy(() -> ValidateUtils.maxLength(source, CarName.CAR_NAME_MAX_LENGTH))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.TOO_LONG_MSG_HOLDER, source);
    }
}