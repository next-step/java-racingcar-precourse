package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int generateNumberWithinRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
