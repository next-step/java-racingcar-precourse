package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {


    public static int generateNumber(int min, int max) {
        if (min == max) {
            return min;
        }
        return min + Randoms.pickNumberInRange(0,9);
    }
}
