package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.Supplier;

public class RandomGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static Supplier<Integer> get() {
        return () -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
