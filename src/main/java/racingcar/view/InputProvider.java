package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.GameMessage;

/**
 * InputProvider
 *
 * @author suji
 * @date 2022-04-23
 **/
public class InputProvider {

    public static String inputCarNames() {
        System.out.println(GameMessage.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputRacingCount() {
        System.out.println(GameMessage.INPUT_RACING_COUNT);
        return Console.readLine();
    }
}
