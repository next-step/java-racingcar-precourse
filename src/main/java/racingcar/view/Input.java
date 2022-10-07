package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.Print.*;

public class Input {
    public static String inputCarNames() {
        printInputRequestName();
        return readLine();
    }
    public static String inputTryCount() {
        printInputRequestTryCount();
        return readLine();
    }
}
