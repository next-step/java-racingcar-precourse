package racingcar.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.GameContext;
import racingcar.view.status.EnterRetryCount;

class MakeRetryCountTest {
    @Test
    @DisplayName("숫자가 아닌 문자가 들어오는 경우")
    void put_not_int() {
        GameContext gameContext = new GameContext();
        gameContext.setRetryReadLine("abcd");
        MakeRetryCount makeRetryCount = new MakeRetryCount();
        assertThat(makeRetryCount.next(gameContext)).isInstanceOf(EnterRetryCount.class);
    }

    @Test
    @DisplayName("정상적인 숫자가 들어오는 경우")
    void put_int() {
        GameContext gameContext = new GameContext();
        gameContext.setRetryReadLine("12");
        MakeRetryCount makeRetryCount = new MakeRetryCount();
        assertThat(makeRetryCount.next(gameContext)).isInstanceOf(GameStep.class);
    }
}