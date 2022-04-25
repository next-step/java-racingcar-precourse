package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingCarConstants;
import racingcar.model.rule.CarMoveRule;
import racingcar.model.rule.PlayCountRule;

public class GameTest {
    CarMoveRule carMoveRule;
    PlayCountRule playCountRule;
    Game game;

    @BeforeEach
    void set() {
        carMoveRule = new CarMoveRule(
                RacingCarConstants.CAR_MOVE_RULE_MOVE_SIZE,
                RacingCarConstants.CAR_MOVE_RULE_STOP_SIZE,
                RacingCarConstants.CAR_MOVE_RULE_MOVE_MIN_CONDITION,
                RacingCarConstants.CAR_MOVE_PRINT_WORD);
        playCountRule = new PlayCountRule(
                RacingCarConstants.PLAY_COUNT_MIN_SIZE,
                RacingCarConstants.PLAY_COUNT_MAX_SIZE
        );
        game = new Game(carMoveRule, playCountRule);
    }

    @DisplayName("game을 처음 생성했을때, GameStatus는 INIT이어야한다.")
    @Test
    void createGameGameStatusIsInit_P01() {
        assertThat(game.gameStatus.isInit()).isTrue();
    }

    @DisplayName("playCount get set 테스트")
    @Test
    void setPlayCountSuccess_P01() {
        game.setPlayCount("5");
        assertThat(game.playCount.equals(new PlayCount("5", playCountRule))).isTrue();
    }
}

