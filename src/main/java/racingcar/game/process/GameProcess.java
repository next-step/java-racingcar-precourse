package racingcar.game.process;

import racingcar.game.GameContext;
import racingcar.game.dto.GameStatus;

public interface GameProcess {

    GameStatus execute(final GameStatus gameStatus);
}
