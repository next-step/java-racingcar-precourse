package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundCountTest {
    @Test
    @DisplayName("모든 라운드가 진행되었는지 확인한다.")
    void 라운드_진행_확인() {
        // given
        int count = RoundCount.MIN_COUNT + 1;
        RoundCount roundCount = new RoundCount(Integer.toString(count));

        // when
        while (roundCount.hasNextRound()) {
            roundCount.nextRound();
        }

        // then
        assertThat(roundCount.hasNextRound()).isFalse();
    } 

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다")
    void 생성시_숫자_유효성검사() {
        // given
        String count = "a";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RoundCount(count))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(ErrorMessage.NOT_DIGIT_ERROR.getMessage());
    }

    @Test
    @DisplayName("음수를 입력하면 예외가 발생한다")
    void 생성시_음수_유효성검사() {
        // given
        String count = "-1";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RoundCount(count))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(
                        ErrorMessage
                                .NEGATIVE_NUMBER_ERROR
                                .getMessage(RoundCount.MIN_COUNT));
    }

    @Test
    @DisplayName("모든 라운드가 진행된 상태에서 라운드 진행시 예외가 발생한다.")
    void 게임종료상태에서_라운드진행시_예외발생(){
        // given
        int count = RoundCount.MIN_COUNT + 1;
        RoundCount roundCount = new RoundCount(Integer.toString(count));

        // when
        while (roundCount.hasNextRound()) {
            roundCount.nextRound();
        }

        // when & then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> roundCount.nextRound())
                .withMessageContaining("[ERROR]")
                .withMessage(ErrorMessage.START_ROUND_WHEN_GAME_OVER_ERROR.getMessage());
    }
}
