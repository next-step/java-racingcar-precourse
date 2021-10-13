package racinggame.service;

import nextstep.utils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int MOVE_NUM = 4;

    @Override
    public boolean isMoving() {
        return  Randoms.pickNumberInRange(MIN, MAX) >= MOVE_NUM;
    }
}
