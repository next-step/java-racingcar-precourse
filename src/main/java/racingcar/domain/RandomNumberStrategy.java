package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberStrategy implements NumberStrategy {
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
    }
}
