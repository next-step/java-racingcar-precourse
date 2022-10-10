package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.AccelRange;
import racingcar.domain.AccelValue;

public class AccelGenerator {
    public static AccelValue generate() {
        return AccelValue.of(Randoms.pickNumberInRange(AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE));
    }
}
