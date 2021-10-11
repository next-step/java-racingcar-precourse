package racinggame.console;

import racinggame.console.input.CarNameInputConsole;
import racinggame.console.input.TryInputConsole;

import java.util.List;

public class GameConsole {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자리 이하 문자만 입력 가능합니다.(공백 입력 불가)";

    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TRY_ERROR_MESSAGE = "[ERROR] 1이상의 정수만 입력 가능합니다.";

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_DELIMITER = ",";

    private final CarNameInputConsole carNameInputConsole
            = new CarNameInputConsole(CAR_NAME_INPUT_MESSAGE, CAR_NAME_ERROR_MESSAGE, CAR_NAME_MAX_LENGTH, CAR_NAME_DELIMITER);
    private final TryInputConsole tryInputConsole = new TryInputConsole(TRY_INPUT_MESSAGE, TRY_ERROR_MESSAGE);

    public List<String> getCarNames() {
        return carNameInputConsole.getInputValue();
    }

    public int getTryCount() {
        return tryInputConsole.getInputValue();
    }


}
