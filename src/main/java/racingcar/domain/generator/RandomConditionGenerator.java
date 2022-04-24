package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Condition;
import racingcar.domain.ConditionGenerator;

public class RandomConditionGenerator implements ConditionGenerator {

    public Condition generate() {
        return new Condition(Randoms.pickNumberInRange(Condition.MIN_VALUE, Condition.MAX_VALUE));
    }

}
