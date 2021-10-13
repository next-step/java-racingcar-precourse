package racinggame.model;

import racinggame.constants.Messages;

import static racinggame.constants.Messages.ERROR_MESSAGE;
import static racinggame.constants.RacingCarConstants.CAR_NAME_DIGIT;

public class CarName {
    private String name;

    public CarName(String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_DIGIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + Messages.CAR_NAME_DIGIT_INVALID.getMessage());
        }

        if (carName.length() == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + Messages.CAR_NAME_BLANK_INVALID.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
