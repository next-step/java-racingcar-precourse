package racingcar.domain.strategy;

import racingcar.domain.car.CarStatus;

public class CarMovingStrategy implements MovingStrategy{

    private static final int MOVING_STATUS_NUMBER = 4;

    @Override
    public CarStatus getMoveStatus(int number) {
        if (number >= MOVING_STATUS_NUMBER) {
            return CarStatus.MOVE;
        }
        return CarStatus.STOP;
    }
}
