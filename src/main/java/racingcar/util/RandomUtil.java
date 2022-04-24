package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    public static long random() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
