package racingcar;

import static racingcar.service.GameUtil.inputCarName;
import static racingcar.service.GameUtil.inputGameCount;
import static racingcar.service.GameUtil.printResult;

public class Application {
    public static void main(String[] args) {
        inputCarName();
        inputGameCount();
        printResult();
    }
}
