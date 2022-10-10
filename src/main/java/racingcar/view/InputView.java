package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

public class InputView {
    public static String inputCarNames() {
        System.out.println(InputMessage.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String inputGameRound() {
        System.out.println(InputMessage.INPUT_GAME_ROUND_MESSAGE);
        return Console.readLine();
    }
}
