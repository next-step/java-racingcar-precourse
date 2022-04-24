package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.RepeatMessage;

class RepeatTest {

    @ParameterizedTest(name = "시도할 횟수가 올바른 값({0})이다")
    @ValueSource(strings = {"1", "2147483647"})
    void validRepeatNumber(String inputNumber) {
        assertThat(Repeat.valueOf(inputNumber)).isNotNull();
    }

    @Test
    @DisplayName("시도할 횟수가 0번이다")
    void invalidRepeatNumberZero() {
        assertThatThrownBy(() -> Repeat.valueOf("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자이나 음수이다")
    void invalidRepeatNumberNegative() {
        assertThatThrownBy(() -> Repeat.valueOf("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("시도할 횟수가 0으로 시작하는 수이다")
    void invalidRepeatNumberStartZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Repeat.valueOf("0123"))
                .withMessage(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
    }

    @ParameterizedTest(name = "시도할 횟수가 숫자가 아닌 값({0})이다")
    @ValueSource(strings = {"mond", "a123", "456b", " 7", "d8c", ""})
    void invalidRepeatNumberCharacter(String inputNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Repeat.valueOf(inputNumber))
                .withMessage(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("시도할 숫자가 Integer.MAX_VALUE를 넘어간 값이다")
    void invalidRepeatNumberOverflow() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Repeat.valueOf("2147483648"))
                .withMessage(RepeatMessage.INVALID_NUMBER_RANGE);
    }

}
