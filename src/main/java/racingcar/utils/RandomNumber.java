package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static final int racingConditionMin = 0;
    public static final int racingConditionMax = 9;

    public int generator() {
        return Randoms.pickNumberInRange(racingConditionMin, racingConditionMax);
    }
}
