package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private static final int minNumber = 0;
    private static final int maxNumber = 9;

    public static int pickNumber() {
        return pickNumberInRange(minNumber, maxNumber);
    }
}
