package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameRoundTest {

    final int racingCarRecord = 3;
    final int round = 1;
    final int wrongRound = -3;

    @Test
    @DisplayName("시도 회수가 음수면 예외를 던진다.")
    void When_Round_Negative_Throws_Exception() {
        assertThatThrownBy(() -> {
            new GameRound(wrongRound);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("자동차는 한번에 한칸 이하로만 움직일 수 있다.")
    void When_Play_Each() {
        int number = new GameRound(round).moveForward(racingCarRecord);
        assertTrue(number == racingCarRecord || number == racingCarRecord + 1);
    }
}
