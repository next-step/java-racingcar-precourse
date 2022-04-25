package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements MovementCondition {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public int moving() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
