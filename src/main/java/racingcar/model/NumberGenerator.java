package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(BEGIN_NUMBER, END_NUMBER);
    }
}
