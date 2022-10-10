package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomIntGenerator implements RandomIntGenerator {

    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
