package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtils {

    private static final int MIN = 0;
    private static final int MAX = 9;

    private RandomNumberUtils() {
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
