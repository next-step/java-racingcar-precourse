package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 9;

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_INDEX, END_INDEX);
    }
}
