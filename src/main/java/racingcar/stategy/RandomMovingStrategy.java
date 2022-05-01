package racingcar.stategy;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomMovingStrategy implements MovingStrategy {

    @Override
    public boolean movable() {
        return pickNumberInRange(1, 9) >= 4;
    }

}
