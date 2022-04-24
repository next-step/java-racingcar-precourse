package racingcar.rule;

import racingcar.car.Car;

@FunctionalInterface
public interface ConditionGenerator {

    static ConditionGenerator random() {
        return RandomConditionGenerator.INSTANCE;
    }

    Condition generate(Car car);
}
