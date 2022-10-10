package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVING_FORWARD = 4;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 0;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE) >= MOVING_FORWARD;
    }
}
