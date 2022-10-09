package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final RandomNumberGenerator instance = new RandomNumberGenerator();
    private static final int MIN = 0;
    private static final int MAX = 9;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator instance() {
        return instance;
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
