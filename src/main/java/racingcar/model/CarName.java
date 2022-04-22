package racingcar.model;

import java.util.Objects;
import racingcar.code.CarValueRange;
import racingcar.code.ErrorCode;

public class CarName {
    private final String carName;

    public CarName(final String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    private void validateCarName(String carName) {
        if (isNull(carName)) {
            throw new NullPointerException(ErrorCode.CAR_NAME_NULL.getErrorMessage());
        }
        if (isLongerThanFive(carName)) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAVE_OVER_MAX_LENGTH.getErrorMessage());
        }
        if (isEmpty(carName)) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_IS_EMPTY.getErrorMessage());
        }
    }

    private boolean isLongerThanFive(String carName) {
        return carName.length() > CarValueRange.MAX_CAR_NAME_LENGTH.getCarValueRange();
    }

    private boolean isNull(String carName) {
        return Objects.isNull(carName);
    }

    private boolean isEmpty(String carName) {
        return carName.isEmpty();
    }
}
