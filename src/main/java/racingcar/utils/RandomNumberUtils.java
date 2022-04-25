package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtils {

    private RandomNumberUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
