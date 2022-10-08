package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public static int generateNumber(int min, int max) {
        return pickNumberInRange(min, max);
    }
}
