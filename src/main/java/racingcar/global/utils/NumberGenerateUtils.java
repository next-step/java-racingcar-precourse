package racingcar.global.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerateUtils {
    private NumberGenerateUtils() {}

    public static int createRandomNumber(int minNumber, int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }
}
