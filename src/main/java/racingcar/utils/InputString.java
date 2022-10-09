package racingcar.utils;

import racingcar.game.GameManager;
import racingcar.model.function.Function;
import racingcar.model.function.ReadyToStart;
import racingcar.view.io.OutputFunction;

public class InputString {

    private String strValue;
    public InputString(String inputStr){

        try{
            isNull(inputStr);
        }catch (IllegalArgumentException e){
            Function gameRestart = new ReadyToStart();
            GameManager gameManager = new GameManager(gameRestart);
            gameManager.next();
        }

        this.strValue = inputStr;
    }

    public static boolean isNull(String input) {

        if ("".equals(input)) {
            OutputFunction.println("[Error]자동차이름을 입력해주세요");
            throw new IllegalArgumentException("[Error]자동차이름을 입력해주세요");
        }

        return false;
    }


    public String getStrValue() {
        return this.strValue;
    }
}
