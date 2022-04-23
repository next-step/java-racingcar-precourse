package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class  RandomNumber {

    public static final int START_RANGE = 0;
    public static final int END_RAGNE = 9;

    private RandomNumber() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(START_RANGE, END_RAGNE);
    }

    public static int generate(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
