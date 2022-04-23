package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.message.SystemMessage;

public class RacingGameInputReader {

    public static String inquireRacingCarNames() {
        System.out.printf(SystemMessage.CAR_NAME_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
