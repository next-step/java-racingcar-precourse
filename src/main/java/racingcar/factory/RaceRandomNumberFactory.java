package racingcar.factory;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.racenumber.RaceNumber;

public class RaceRandomNumberFactory {
    private static final int MIN = 0;
    private static final int MAX = 9;

    public static RaceNumber create() {
        return RaceNumber.from(Randoms.pickNumberInRange(MIN, MAX));
    }
}
