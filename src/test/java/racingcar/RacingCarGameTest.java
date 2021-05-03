package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {

    @DisplayName("자동차 이름은 중복되지 않고, 공백이 없어야 한다.")
    @ValueSource(strings = {"123, 123", "", "        "})
    @ParameterizedTest
    void car_name_validation(String input) {
        assertThatThrownBy(() -> {
            new RacingCarGame(input, "1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백을 포함하지 않고, 중복되지 않아야 합니다.");
    }

    @DisplayName("시도할 횟수는 0보다 큰 숫자여야 한다.")
    @ValueSource(strings = {"", "        ", "한글 입력", "abcd", "0", "-23"})
    @ParameterizedTest
    void game_count_validation(String input) {
        assertThatThrownBy(() -> {
            new RacingCarGame("123, 456", input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 0보다 큰 숫자여야 합니다.");
    }

}
