package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public static int makeNumber() {
        return Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
    }
}
