package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameMessage;

public class InputView {

    public String inputCarName() {
        System.out.println(GameMessage.INPUT_CAR_NAME.getMessage());
        return Console.readLine();
    }

    public String inputRacingCount() {
        System.out.println(GameMessage.INPUT_RACE_COUNT.getMessage());
        return Console.readLine();
    }
}
