package racingcar.model.function;

import racingcar.game.GameManager;

public class ExitGame implements Function {
    @Override
    public Function next(GameManager gameManager) {
        return new ExitGame();
    }

    @Override
    public boolean isPlay() {
        return false;
    }
}
