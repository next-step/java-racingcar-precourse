package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b"})
    @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException가 발생한다.")
    void check_validate_number_test(String tryCount) {
        assertThatThrownBy(() ->
            new Number(tryCount)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }
}