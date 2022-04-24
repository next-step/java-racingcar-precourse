package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public final class PositionRandomUtil {

    private static int MIN_NUMBER = 0;
    private static int MAX_NUMBER = 9;
    private static int BENCH_MARK = 3;

    public static boolean tryoutMove() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) > BENCH_MARK;
    }
}

