package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCarRandomNumberGenerator {
    private static final int RACING_CAR_MIN_NUMBER = 0;
    private static final int RACING_CAR_MAX_NUMBER = 9;

    private RacingCarRandomNumberGenerator() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(RACING_CAR_MIN_NUMBER, RACING_CAR_MAX_NUMBER);
    }
}
