package racingcar.model.function;

import racingcar.game.GameManager;

public interface Function {
    Function next(GameManager gameManager);

    boolean isPlay();
}
