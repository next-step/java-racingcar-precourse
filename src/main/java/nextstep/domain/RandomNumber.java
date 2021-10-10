package nextstep.domain;

import nextstep.utils.Randoms;

public class RandomNumber implements Random{

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
