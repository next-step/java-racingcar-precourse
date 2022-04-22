package racingcar.model.lap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LapCountTest {
    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"1", "100", "9999"})
    @DisplayName("1 ~ 9999 사이의 경주 횟수를 생성한다.")
    void createLapCount(String value) {
        // given

        // when
        LapCount lapCount = assertDoesNotThrow(() -> new LapCount(value));

        // then
        assertThat(lapCount.getCount()).isEqualTo(Integer.parseInt(value));
    }

    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"", " ", "a", "0", "10000"})
    @DisplayName("경주 횟수가 빈값, 공백, 문자, 1미만, 9999 초과면 예외가 발생한다.")
    void createLapCountThrows(String value) {
        // given

        // when
        Executable executable = () -> new LapCount(value);

        // then
        assertThrows(IllegalArgumentException.class, executable);
    }
}
