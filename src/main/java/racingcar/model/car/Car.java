package racingcar.model.car;

import racingcar.model.racing.RacingStatus;
import racingcar.model.racing.RacingStrategy;

public class Car {
    private final CarPosition carPosition;

    public Car() {
        this.carPosition = new CarPosition();
    }

    public void race(RacingStrategy racingStrategy, LapCount lapCount) {
        for (int i = 0; i < lapCount.getLapCount(); i++) {
            race(racingStrategy);
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
