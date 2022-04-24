package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Message;

public class InputView {
    public static String inputCarNameView() {
        System.out.println(Message.CAR_NAME_INPUT);
        return Console.readLine();
    }

    public static String inputTryCountView() {
        System.out.println(Message.TRY_COUNT_INPUT);
        return Console.readLine();
    }
}
