package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundCountTest {
    @DisplayName("빈 값을 넣었을 때 에러 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void inputEmpty(String input) {
        assertThatThrownBy(() -> new RoundCount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자를 넣었을 때 에러 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = { "a", "gogo" })
    void inputNotNumberString(String input) {
        assertThatThrownBy(() -> new RoundCount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이하의 값을 입력했을 때 에러 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = { "0", "-1", "-10" })
    void inputLessZero(String input) {
        assertThatThrownBy(() -> new RoundCount(input)).isInstanceOf(IllegalArgumentException.class);
    }
}