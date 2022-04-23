package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.OptionConstants;
import racingcar.enums.CarMovingStateEnum;

public class CarMovingStateUtil {
    public static CarMovingStateEnum judgeMovingState() {
        if (Randoms.pickNumberInRange(OptionConstants.RANDOM_RANGE_MIN, OptionConstants.RANDOM_RANGE_MAX)
                >= OptionConstants.MOVING_THRESHOLD) {
            return CarMovingStateEnum.MOVE;
        }

        return CarMovingStateEnum.STOP;
    }
}
