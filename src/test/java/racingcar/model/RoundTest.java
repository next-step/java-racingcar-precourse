package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-10", "abc", " 1"})
    @DisplayName("게임 반복 횟수로 0이하 및 문자열 입력 시 예외 발생")
    void gameCount_notNumber(String input) {
        Assertions.assertThatThrownBy(() -> Round.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("게임 반복 횟수로 공백 입력 시 예외 발생")
    void gameCount_isBlank(String input) {
        Assertions.assertThatThrownBy(() -> Round.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
