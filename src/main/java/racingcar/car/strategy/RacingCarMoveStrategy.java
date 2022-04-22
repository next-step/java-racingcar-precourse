package racingcar.car.strategy;

import racingcar.car.RacingCarPosition;

public interface RacingCarMoveStrategy {
    int MOVE_THRESHOLD = 4;

    RacingCarPosition tryMove(RacingCarPosition prevPosition);
}
