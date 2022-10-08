package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 정상 입력")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 자동차_이름_정상_입력(final String input) {
        assertDoesNotThrow(() -> new CarName(input));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 비정상 입력")
    @ValueSource(strings = {"raemerrr", "  ", ""})
    void 자동차_이름_비정상_입력_1() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("raemerrr"));
    }
}
