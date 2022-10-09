package racingcar.model.function;

import racingcar.game.GameManager;
import racingcar.utils.InputNumber;

public class ProcessGame implements Function{
    @Override
    public Function next(GameManager gameManager) {
        InputNumber inputNumber = gameManager.iterationInput();

        gameManager.iterationRacing(inputNumber);

        return new FinishGame();
    }

    @Override
    public boolean isPlay() {
        return true;
    }
}
