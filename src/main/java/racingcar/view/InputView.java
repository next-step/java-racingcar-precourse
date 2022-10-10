package racingcar.view;

import static racingcar.constant.RacingGameMessage.RACING_CAR_NAME_INPUT;
import static racingcar.constant.RacingGameMessage.RACING_CAR_TRY_COUNT_INPUT;
import static racingcar.utils.ConvertUtil.*;
import static racingcar.utils.ScannerUtil.*;

public class InputView {

    private static final String COMMA = ",";

    public static String[] RacingCarInputNames() {
        printMessage(RACING_CAR_NAME_INPUT);
        return splitByComma(readLine());
    }

    public static int RacingCarInputsTry() {
        printMessage(RACING_CAR_TRY_COUNT_INPUT);
        return convertStringToInteger(readLine());
    }

    private static String[] splitByComma(String input) {
        return input.split(COMMA);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}
