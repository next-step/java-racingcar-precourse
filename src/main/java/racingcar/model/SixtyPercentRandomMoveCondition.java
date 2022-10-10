package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class SixtyPercentRandomMoveCondition implements RandomMoveCondition {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVABLE_NUMBER_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
            >= MOVABLE_NUMBER_THRESHOLD;
    }
}
