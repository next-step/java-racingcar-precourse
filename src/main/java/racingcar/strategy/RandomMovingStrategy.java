package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int CRITERIA_NUMBER = 4;

    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= CRITERIA_NUMBER;
    }
}
