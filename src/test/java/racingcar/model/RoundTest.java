package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"as", "1da", " ", "!23"})
    @DisplayName("유효하지 않은 라운드")
    void round_fail(String round) {
        assertThrows(IllegalArgumentException.class, () -> new Round(round));
    }
}