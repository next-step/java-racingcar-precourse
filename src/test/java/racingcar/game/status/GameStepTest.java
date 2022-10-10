package racingcar.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList;
import racingcar.game.GameContext;

class GameStepTest {
    @Test
    @DisplayName("재설정 횟수만큼 스텝을 진행하면 게임결과화면으로 진행확인")
    void check_game_step_full() {
        GameContext gameContext = new GameContext();
        gameContext.setCarList(new CarList("abc"));
        int retryCount = 5;
        gameContext.setRetryCount(retryCount);
        while (retryCount-- > 0) {
            gameContext.increaseStep();
        }
        GameStep gameStep = new GameStep();
        assertThat(gameStep.next(gameContext)).isInstanceOf(GameResult.class);
    }

    @Test
    @DisplayName("재설정 횟수만큼 스텝을 진행하지 않으면 게임이 계속 진행")
    void check_game_step_ongoing() {
        GameContext gameContext = new GameContext();
        gameContext.setCarList(new CarList("abc"));
        int retryCount = 5;
        gameContext.setRetryCount(retryCount);
        gameContext.increaseStep();
        GameStep gameStep = new GameStep();
        assertThat(gameStep.next(gameContext)).isInstanceOf(GameStep.class);
    }

}