package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int START = 1;
    private static final int END = 9;

    public static int create() {
        return Randoms.pickNumberInRange(START, END);
    }
}
