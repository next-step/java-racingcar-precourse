package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.message.SystemMessage;

public class RacingCarGameInputReader {

    public static String inquireRacingCarNames() {
        System.out.printf(SystemMessage.CAR_NAME_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public static String inquireRacingCarGameRounds() {
        System.out.printf(SystemMessage.RACING_CAR_GAME_ROUND_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
