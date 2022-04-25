package racingcar.domain;

import racingcar.util.RandomNumber;

public class GameRule {
    private static final int MIN_CRITERIA = 0;
    private static final int MAX_CRITERIA = 9;
    private static final int MIN_FORWARD_CONDITION = 4;

    public static boolean isForward() {
        int randomNumber = RandomNumber.generateNumberWithinRange(MIN_CRITERIA, MAX_CRITERIA);
        return randomNumber >= MIN_FORWARD_CONDITION;
    }
}
