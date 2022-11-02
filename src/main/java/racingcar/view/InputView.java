package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Message;

public class InputView {
    private InputView() {
    }

    public static String inputCarNames() {
        OutputView.print(Message.INPUT_CAR_NAME.getMessage());
        return Console.readLine();
    }

    public static String inputRoundCount() {
        OutputView.print(Message.INPUT_ROUND_COUNT.getMessage());
        return Console.readLine();
    }
}
