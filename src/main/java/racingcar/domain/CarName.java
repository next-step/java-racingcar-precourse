package racingcar.domain;

import racingcar.exception.InvalidParameterError;
import racingcar.message.ErrorMessage;

public class CarName {
    private final String carName;
    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 5;

    public CarName(String carName) {
        validLength(carName);
        validFormat(carName);
        this.carName = carName;
    }

    private void validLength(String carName) {
        if (carName.length() >= MIN_LENGTH && carName.length() <= MAX_LENGTH) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.CAR_NAME_LENGTH_ERROR);
    }

    private void validFormat(String carName) {
        final String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9]*$";
        if (carName.matches(ALPHANUMERIC_REGEX)) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.CAR_NAME_FORMAT_ERROR);
    }

    public String getCarName() {
        return this.carName;
    }
}
