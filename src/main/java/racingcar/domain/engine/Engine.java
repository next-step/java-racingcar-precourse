package racingcar.domain.engine;

import racingcar.constant.Conditions;
import racingcar.generator.NumberGenerator;

public class Engine {
    private final NumberGenerator numberGenerator;

    private Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static Engine createBy(NumberGenerator numberGenerator) {
        return new Engine(numberGenerator);
    }

    public MoveStatus run() {
        if (numberGenerator.generate() >= Conditions.MOVE_FORWARD_CONDITION) {
            return MoveStatus.FORWARD;
        }

        return MoveStatus.STOP;
    }
}
