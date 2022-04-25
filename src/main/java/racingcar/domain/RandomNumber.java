package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private int number;
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;
    public static final String NUM_RANGE = "^[" + START_NUM + "-" + END_NUM + "]*$";
    private static final String ERROR_RANDOM_NUMBER = "[ERROR] 랜덤 넘버 범위가 잘못 산정되었습니다.";

    public RandomNumber() {
        number = pickNumberInRange(START_NUM, END_NUM);
        verifyingRange(number);
    }

    private void verifyingRange(int number) {
        if (!Integer.toString(number).matches(NUM_RANGE)) {
            throw new IllegalArgumentException(ERROR_RANDOM_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }
}
