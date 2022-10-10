package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.util.Scale.*;

public class RandomStrategy implements RollStrategy {
    public RollResult roll(Car car) {
        int number = pickNumberInRange(MOVE_MIN, MOVE_MAX);
        if (number < MOVE_BORDER) {
            return new RollResult(false, car);
        }
        car.move();
        return new RollResult(true, car);
    }
}
