package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private RandomUtils() {}

    public static int getRandomNumberForMove() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
