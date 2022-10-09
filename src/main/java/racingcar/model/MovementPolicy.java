package racingcar.model;

import racingcar.constant.GameEnvironment;

public class MovementPolicy {
    public static MovementAction action() {
        return RandomNumber.generate() >= GameEnvironment.MOVEMENT_RANDOM_BOUNDARY
                ? MovementAction.MOVE
                : MovementAction.STOP;
    }
}
