package racingcar.domain.model;

import racingcar.core.common.error.CarErrorCode;
import racingcar.domain.dto.PlayHistory;

public class Car {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 9;
    private static final int MINIMUM_VALUE_TO_MOVE_FORWARD = 4;

    private final CarName name;
    private final Distance distance;

    public Car(final String name) {
        this.name = new CarName(name);
        this.distance = new Distance();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public PlayHistory moveForward(final int pickNumber) {
        validateRange(pickNumber);
        if (MINIMUM_VALUE_TO_MOVE_FORWARD <= pickNumber) {
            distance.increase();
        }

        return new PlayHistory(name.getName(), distance.getDistance());
    }

    private void validateRange(final int pickNumber) {
        if (MINIMUM_VALUE > pickNumber || MAXIMUM_VALUE < pickNumber) {
            throw new IllegalArgumentException(CarErrorCode.NOT_ALLOW_PICK_NUMBER.getErrorMessage());
        }
    }
}