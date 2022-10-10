package racingcar.game.status;

import racingcar.game.GameContext;

public class Exit implements Status {
    @Override
    public Status next(GameContext gameContext) {
        return null;
    }
}
