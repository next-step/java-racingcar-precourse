package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Message.InputMessage;

public class InputView {
    public static String inputNumber() {
        System.out.println(InputMessage.INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputRacingCarNames() {
        System.out.println(InputMessage.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
}
