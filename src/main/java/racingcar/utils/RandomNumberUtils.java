package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;

public class RandomNumberUtils {

    private RandomNumberUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static int getRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
