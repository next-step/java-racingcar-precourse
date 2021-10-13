package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomMovableStrategy implements MovableStrategy{
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;
    private static final int MOVING_FORWARD = 4;        // 4 이상 전진 / 3이하 정지

    @Override
    public boolean movable() {
        return getRandomNo() >= MOVING_FORWARD;
    }

    private int getRandomNo() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
