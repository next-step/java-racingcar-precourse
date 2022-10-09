package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameMessage;
import racingcar.model.Names;
import racingcar.model.RaceCount;

public class InputConsole {
    public static Names readCarNames() {
        return new Names(new UserInput(carNamesInputView()));
    }

    public static RaceCount readRaceCount() {
        return new RaceCount(new UserInput(raceCountInputView()));
    }

    private static String carNamesInputView() {
        System.out.println(GameMessage.CAR_NAME_INPUT);
        return Console.readLine();
    }

    private static String raceCountInputView() {
        System.out.println(GameMessage.RACE_COUNT_INPUT);
        return Console.readLine();
    }
}