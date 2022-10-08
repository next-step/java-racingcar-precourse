package racingcar.model;

import racingcar.model.enums.ErrorType;

import static racingcar.common.Constants.INVALID_MAX_CAR_NAME;
import static racingcar.common.Constants.INVALID_MIN_CAR_NAME;

public class CarName {

    private final String name;

    public CarName(String inputName) {
        if (inputName.length() > INVALID_MAX_CAR_NAME) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
        }

        if (inputName.length() < INVALID_MIN_CAR_NAME) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
        }

        this.name = inputName;
    }

    public String getName() {
        return name;
    }
}
