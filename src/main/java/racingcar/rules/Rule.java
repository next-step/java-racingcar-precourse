package racingcar.rules;

import camp.nextstep.edu.missionutils.Randoms;

public class Rule {

    public static final int MIN_OF_RANDOM_NUMBER = 0;
    public static final int MAX_OF_RANDOM_NUMBER = 9;
    public static final int MIN_OF_MOVE_NUMBER = 4;

    public static boolean isMovingForward() {

        return Randoms.pickNumberInRange(MIN_OF_RANDOM_NUMBER, MAX_OF_RANDOM_NUMBER) >= MIN_OF_MOVE_NUMBER;
    }

}
