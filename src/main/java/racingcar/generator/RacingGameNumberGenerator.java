package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Conditions;

public class RacingGameNumberGenerator implements NumberGenerator {
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(Conditions.RACING_NUMBER_MIN, Conditions.RACING_NUMBER_MAX);
    }
}
