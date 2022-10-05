package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.Constants.COMMON_ERROR_HEADER;
import static racingcar.common.Constants.ERROR_TRIAL_RANGE_OVER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LapsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 12, 123})
    @DisplayName("fromTest:[success]")
    void fromTest(int input) {
        //when
        Laps laps = Laps.from(input);
        //then
        assertThat(laps).isInstanceOf(Laps.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -12, -123})
    @DisplayName("from (음수 입력 예외):[failure]")
    void from_inputRangeException(int input) {
        //when&then
        assertThatThrownBy(() -> Laps.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMON_ERROR_HEADER.concat(ERROR_TRIAL_RANGE_OVER));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 12, 123})
    @DisplayName("getLapCount:[success]")
    void getLapCount(int input) {
        //when
        Laps laps = Laps.from(input);
        //then
        assertThat(laps.getLapCount()).isEqualTo(input);
    }
}