package racinggame.domain;

import racinggame.msg.ErrorMessage;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getName() {
        return carName;
    }

    private void validateCarName(String carName) {
        isNotNull(carName);
        isValidLength(carName);
        isNotInBlank(carName);
    }

    private void isNotNull(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_CAN_NOT_BE_NULL);
        }
    }

    private void isValidLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_CAN_BE_IN_VALID_RANGE);
        }
    }

    private void isNotInBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_CAN_NOT_BE_IN_BLANK);
        }
    }
}
