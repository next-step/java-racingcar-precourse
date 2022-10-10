package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacinggameException;

class RoundTest {

    @Test
    @DisplayName("Round 생성 확인")
    void createCar() {
        Round round = Round.from("5");

        assertThat(round.getRound()).isEqualTo(5);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자를 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkRoundType() {
        assertThatThrownBy(() -> Round.from("5#"))
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Check the input value or type");
    }
}
