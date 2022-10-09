package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.ErrorMessage.ROUND_ONLY_NUMBER;
import static racingcar.common.ErrorMessage.ROUND_NO_ZERO;

@DisplayName("회차 테스트")
class RoundTest {

    @Test
    @DisplayName("01_숫자 테스트")
    public void number_test() {
        assertSimpleTest(() -> assertThat(new Round("1").getRound()).isEqualTo(1));
    }

    @Test
    @DisplayName("02_숫자 포맷 테스트")
    public void number_format() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Round("abc"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ROUND_ONLY_NUMBER));
    }

    @Test
    @DisplayName("03_회수 0 테스트")
    public void number_no_zero() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Round("0"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ROUND_NO_ZERO));
    }

}