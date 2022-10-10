package racingcar.model;

import racingcar.utils.Constants;

public class CarPosition {
    private final Integer carPosition;

    public CarPosition() {
        this.carPosition = Constants.DEFAULT_CAR_POSITION;
    }

    public CarPosition(Integer newPosition) {
        this.carPosition = newPosition;
    }

    public Integer getCarPosition() {
        return this.carPosition;
    }
}
