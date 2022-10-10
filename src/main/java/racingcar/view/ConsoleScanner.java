package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class ConsoleScanner {
    private static final String CAR_NAME_DELIMITER = ",";

    public static String getUserInput() {
        return Console.readLine();
    }

    public static List<String> getCarNames() {
        List<String> carNames = Arrays.asList(Console.readLine().split(CAR_NAME_DELIMITER));
        return carNames;
    }
}
