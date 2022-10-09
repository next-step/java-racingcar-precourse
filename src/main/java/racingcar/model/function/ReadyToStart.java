package racingcar.model.function;

import racingcar.game.GameManager;

public class ReadyToStart implements Function{

    @Override
    public Function next(GameManager gameManager) {
        gameManager.init();
        return new ProcessGame();
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
