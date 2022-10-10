package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVE_CONDITION_NUMBER = 4;


    @Override
    public boolean movable() {
        return getRandomNumber() >= MOVE_CONDITION_NUMBER;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
