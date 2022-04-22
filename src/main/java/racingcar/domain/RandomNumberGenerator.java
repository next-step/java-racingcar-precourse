package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int MIN_BOUND = 0;
    public static final int MAX_BOUND = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
