package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    public static final int MOVING_CRITERION = 4;

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    @Override
    public boolean isMovable() {
        return getRandomNumber() >= MOVING_CRITERION;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
