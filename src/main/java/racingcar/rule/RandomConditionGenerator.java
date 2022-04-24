package racingcar.rule;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

enum RandomConditionGenerator implements ConditionGenerator {

    INSTANCE;

    @Override
    public Condition generate(Car car) {
        final int random = Randoms.pickNumberInRange(Condition.MIN, Condition.MAX);
        return Condition.of(random);
    }
}
