package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy{

    private final static int RANDOM_MAX_NUMBER = 9;
    private final static int RANDOM_MIN_NUMBER = 0;
    private final static int MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER) >= MOVABLE_NUMBER;
    }
}
