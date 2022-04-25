package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    private static final String ROUND_GO_ERROR_MESSAGE = "남은 시도 횟수는 0입니다.";
    private static final String ROUND_EMPTY_ERROR_MESSAGE = "시도 횟수는 필수값입니다.";
    private static final String ROUND_RANGE_ERROR_MESSAGE = "시도 횟수는 1-2147483647 사이 숫자만 가능합니다.";

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 에러를 던진다.")
    void throw_error_with_not_numeric() {
        String givenText = "a";
        assertThatThrownBy(
            () -> new Round(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ROUND_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("시도 횟수가 입력되지 않을 경우 에러를 던진다.")
    void throw_error_with_empty(String givenText) {
        assertThatThrownBy(
            () -> new Round(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ROUND_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2147483648"})
    @DisplayName("시도 횟수가 1보다 작을 경우 에러를 던진다.")
    void throw_error_with_negative(String givenText) {
        assertThatThrownBy(
            () -> new Round(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ROUND_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649"})
    @DisplayName("시도 횟수가 int 범위를 벗어날 경우 에러를 던진다.")
    void throw_error_with_max(String givenText) {
        assertThatThrownBy(
            () -> new Round(givenText)
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ROUND_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("남은 횟수가 0이면 true를 리턴한다.")
    void over() {
        // given
        Round round = new Round("1");
        // when
        round.go();
        // then
        assertThat(round.isOver()).isEqualTo(true);
    }

    @Test
    @DisplayName("남은 횟수가 0 이하일 경우 에러를 던진다.")
    void throw_error_with_no_round() {
        // given
        Round round = new Round("1");
        // when
        round.go();
        // then
        assertThatThrownBy(
            () -> round.go()
        ).isInstanceOf(IllegalStateException.class)
        .hasMessage(ROUND_GO_ERROR_MESSAGE);
    }
}
