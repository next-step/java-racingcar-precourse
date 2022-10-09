package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Error;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameTest {
    @DisplayName("자동차 이름은 빈 값이 될 수 없다")
    @Test
    void 자동차_이름공백_테스트() {
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.EMPTY_NAME.toString());
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"6개의이름차", "7개의이름자동", "8개의이름자동차"})
    void 자동차_이름길이_테스트(String input) {
        assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.TOO_LONG_NAME.toString());
    }
}
