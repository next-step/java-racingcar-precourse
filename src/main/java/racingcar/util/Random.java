package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    private static final int MIN_NUMBER = 0;

    private static final int MAX_NUMBER = 9;

    public static int location() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
