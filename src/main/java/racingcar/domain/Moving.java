package racingcar.domain;

import racingcar.constant.GameCondition;
import racingcar.domain.number.NumberGenerator;

public class Moving {
    private final NumberGenerator numberGenerator;

    private Moving(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static Moving by(NumberGenerator numberGenerator) {
        return new Moving(numberGenerator);
    }

    public MovingCommand move() {
        if (this.numberGenerator.generate() >= GameCondition.MOVE_FORWARD_BIFURCATION) {
            return MovingCommand.MOVE_FORWARD;
        }

        return MovingCommand.STOP;
    }
}
