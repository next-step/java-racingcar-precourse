package racingcar.controller;

import static racingcar.config.CarMovingConfig.RACING_CAR_NAME_INPUT_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.model.user.RacingRepeatCount;
import racingcar.model.user.UserInputCarNames;

public class UserInputController {

    public static UserInputCarNames getCarsName() {
        String readLine = Console.readLine();
        String[] readLineSplit = readLine.split(RACING_CAR_NAME_INPUT_DELIMITER);
        return new UserInputCarNames(Arrays.asList(readLineSplit));
    }

    public static RacingRepeatCount getRacingRepeatCount() {
        String readLine = Console.readLine();
        int repeatCount;

        try {
            repeatCount = Integer.parseInt(readLine);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        return new RacingRepeatCount(repeatCount);
    }

}
