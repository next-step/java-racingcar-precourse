package racingcar.model.car;

import racingcar.constant.ErrorMessage;
import racingcar.model.racing.RacingStatus;
import racingcar.model.racing.RacingStrategy;

public class Car {
    private final CarPosition carPosition;

    public Car() {
        this.carPosition = new CarPosition();
    }

    public void race(RacingStrategy racingStrategy, int racingCount) {
        validate(racingCount);

        for (int i = 0; i < racingCount; i++) {
            race(racingStrategy);
        }
    }

    private void validate(int racingCount) {
        if (racingCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.CAR_RACING_COUNT_GREATER_THAN_ZERO);
        }
    }

    private void race(RacingStrategy racingStrategy) {
        RacingStatus racingStatus = racingStrategy.race();
        if (racingStatus.isGo()) {
            carPosition.increasePosition();
        }
    }

    public int getPosition() {
        return carPosition.getPosition();
    }
}
