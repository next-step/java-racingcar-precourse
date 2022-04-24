package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exceptions.IllegalArgumentException;

public class RacingTurnTest {

    @Test
    void valid() {
        assertThat(new RacingTurn("3").get()).isEqualTo(3);
    }

    @Test
    @DisplayName("턴 수가 0 이하일 때, 오류가 발생하는가")
    void error_zero_turn() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                RacingTurn racingTurn = new RacingTurn("0");
            })
            .withMessageContaining("1 이상의 턴 수를 입력해주세요.")
            .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("턴 수를 숫자로 입력하지 않았을 때, 오류가 발생하는가")
    void error_not_number_turn() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                RacingTurn racingTurn = new RacingTurn("zero");
            })
            .withMessageContaining("턴 수를 숫자로 입력해주세요.")
            .withMessageContaining("[ERROR]");
    }
}
