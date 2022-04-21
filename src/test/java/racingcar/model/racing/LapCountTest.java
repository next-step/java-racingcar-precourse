package racingcar.model.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.model.car.CarConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LapCountTest {
    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"1", "100", "2147483647"})
    @DisplayName("1 ~ Integer.MAX_VALUE 사이의 경주 횟수를 생성한다.")
    void createLapCount(String value) {
        // given

        // when
        LapCount lapCount = assertDoesNotThrow(() -> new LapCount(value));

        // then
        assertThat(lapCount.getLapCount()).isEqualTo(Integer.parseInt(value));
    }

    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"", " ", "a", "0", "2147483648"})
    @DisplayName("경주 횟수가 빈값, 공백, 문자, 0 이하, Integer.MAX_VALUE 초과면 예외가 발생한다.")
    void createLapCountThrows(String value) {
        // given

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new LapCount(value));

        // then
        assertThat(exception.getMessage()).isEqualTo(
                String.format(ErrorMessage.INVALID_CAR_RACING_COUNT_RANGE, CarConfig.MIN_LAP_COUNT,
                              Integer.MAX_VALUE));
    }
}
