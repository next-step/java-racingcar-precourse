package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "가"})
    void 레이싱_자동차_이동횟수는_숫자(String input) {
        assertThatThrownBy(() -> new Racing(input)).isInstanceOf(IllegalArgumentException.class);
    }
}