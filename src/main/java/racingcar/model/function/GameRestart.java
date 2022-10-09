package racingcar.model.function;

import racingcar.game.GameManager;

public class GameRestart implements Function{
    @Override
    public Function next(GameManager gameManager) {
        return new ReadyToStart();
    }

    @Override
    public boolean isPlay() {
        return isPlay();
    }
}
