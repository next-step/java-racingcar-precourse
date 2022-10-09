package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class MathUtil {

    public static int randomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
