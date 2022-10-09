package racingcar.utils;

import racingcar.game.GameManager;
import racingcar.model.function.Function;
import racingcar.model.function.ProcessGame;
import racingcar.view.io.OutputFunction;

public class InputNumber {
    private final int iterationCount;
    public InputNumber(String iterCount) {
        int iInputVal = 0;
        try {
            iInputVal = checkOnlyNumber(iterCount);
        }catch (IllegalArgumentException e){
            Function inputCount = new ProcessGame();
            GameManager gameManager = new GameManager(inputCount);
            gameManager.next();
        }
        this.iterationCount = iInputVal;
    }

    private int checkOnlyNumber(String data){
        try {
            return Integer.valueOf(data);
        }catch (IllegalArgumentException e){
            OutputFunction.println("[ERROR] 숫자만 사용가능합니다!");
            throw new IllegalArgumentException("숫자만 사용가능합니다!");
        }
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

}
