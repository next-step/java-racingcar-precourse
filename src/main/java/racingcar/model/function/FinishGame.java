package racingcar.model.function;

import racingcar.game.GameManager;

public class FinishGame implements Function{
    @Override
    public Function next(GameManager gameManager) {
        gameManager.showResult();
        return new ExitGame();
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
