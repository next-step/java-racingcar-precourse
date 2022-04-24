package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MOVE_START_NUM = 1;
    private static final int MOVE_END_NUM = 9;

    private RandomNumber() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(MOVE_START_NUM, MOVE_END_NUM);
    }

    public static int generate(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
