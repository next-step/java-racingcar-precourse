package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.RacingCarUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarUtilsTest {

    @Test
    public void 자동차_라운드_숫자_검증() {
        assertThatThrownBy(() ->
                RacingCarUtils.roundNumber("12T"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    public void 자동차_라운드_숫자_검증_제로() {
        assertThatThrownBy(() ->
                RacingCarUtils.roundNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
