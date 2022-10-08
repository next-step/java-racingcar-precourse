package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMovingStrategy implements MovingStrategy {
    private static final int MOVING_MIN_NUMBER = 0;
    private static final int MOVING_MAX_NUMBER = 9;
    private static final int MOVING_BOUNDED_NUMBER = 4;

    @Override
    public boolean move() {
        return MOVING_BOUNDED_NUMBER <= Randoms.pickNumberInRange(MOVING_MIN_NUMBER, MOVING_MAX_NUMBER);
    }
}
