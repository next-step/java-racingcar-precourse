package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static final int MINIMUM_RANGE_OF_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANGE_OF_RANDOM_NUMBER = 9;
    private static final int ZERO_IDX = 0;

    public static int[] generate(int numberOfGenerated) {

        int[] randomNumbers = new int[numberOfGenerated];

        for (int idx = ZERO_IDX; idx < numberOfGenerated; idx++) {
            randomNumbers[idx] = Randoms.pickNumberInRange(MINIMUM_RANGE_OF_RANDOM_NUMBER, MAXIMUM_RANGE_OF_RANDOM_NUMBER);
        }

        return randomNumbers;
    }
}
