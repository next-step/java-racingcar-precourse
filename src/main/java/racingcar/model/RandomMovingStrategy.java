package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVABLE_LOWER_BOUND = 4;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;

    private static final RandomMovingStrategy self = new RandomMovingStrategy();

    public boolean move() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND) >= MOVABLE_LOWER_BOUND;
    }

    public static RandomMovingStrategy getInstance() {
        return self;
    }


}
