package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.Cars;
import racingcar.view.OutputResult;

public class RandomForward {
    public static void setCarsForward(Cars cars) {
        for (String key : cars.getCarMap().keySet()) {
            cars.getCarMap().put(key, setRandomValue(cars.getCarMap().get(key)));
            OutputResult.printCarForwardState(key, cars.getCarMap().get(key));
        }
        OutputResult.printNewLineMessage("");
    }

    private static int setRandomValue(int moveCount) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveCount++;
        }
        return moveCount;
    }
}
