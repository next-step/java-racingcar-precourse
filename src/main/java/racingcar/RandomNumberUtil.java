package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil {

    private final static int MIN_NUMBER = 0;
    private final static int MAX_NUMBER = 9;

    public static int getNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
