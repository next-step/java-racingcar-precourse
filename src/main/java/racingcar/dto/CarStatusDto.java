package racingcar.dto;

import racingcar.model.Distance;

public final class CarStatusDto {

    private final String carName;
    private final Distance carDistance;

    public CarStatusDto(final String carName, final Distance carDistance) {
        this.carName = carName;
        this.carDistance = carDistance;
    }

    public String getCarName() {
        return carName;
    }

    public Distance getCarDistance() {
        return carDistance;
    }
}
