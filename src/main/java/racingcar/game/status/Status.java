package racingcar.game.status;

import racingcar.game.GameContext;

public interface Status {
    Status next(final GameContext gameContext);
}
