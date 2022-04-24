package racingcar.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameCondition;

public class GameNumberGenerator implements NumberGenerator {
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(GameCondition.MIN_ROUND_RANDOM_KEY, GameCondition.MAX_ROUND_RANDOM_KEY);
    }
}
