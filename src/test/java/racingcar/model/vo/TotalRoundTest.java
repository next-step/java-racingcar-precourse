package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalRoundTest {

    @Test
    @DisplayName("시도 횟수 1 이상 확인")
    void 시도_횟수_크기_확인() {
        assertThat(TotalRound.validateRoundCount(0)).isFalse();
        assertThat(TotalRound.validateRoundCount(1)).isTrue();
    }

    @Test
    @DisplayName("시도 횟수 숫자인지 확인")
    void 시도_횟수_숫자_확인() {
        assertThat(TotalRound.validateRoundNumber("12")).isTrue();
        assertThat(TotalRound.validateRoundNumber("12abc")).isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 1 미만인 경우 예외처리")
    void 시도횟수_1미만_예외처리() {
        assertThatThrownBy(() -> {
            new TotalRound(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> {
            new TotalRound(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> {
            new TotalRound("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> {
            new TotalRound("-1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("시도 횟수 숫자 아닌 경우 예외처리")
    void 시도횟수_문자_예외처리() {
        assertThatThrownBy(() -> {
            new TotalRound("1abc");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
