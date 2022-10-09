package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.GameMessage;

public class InputProvider {
    public static String inputCarNames() {
        System.out.println(GameMessage.INPUT_CAR_NAMES);
        return Console.readLine();
    }
    public static String inputPlayingCount() {
        System.out.println(GameMessage.INPUT_PLAYING_COUNT);
        return Console.readLine();
    }
}
