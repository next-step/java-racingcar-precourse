package racingcar.domain.strategy;

import racingcar.domain.car.CarStatus;

public interface MovingStrategy {
    CarStatus getMoveStatus(int number);
}
