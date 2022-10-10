package racingcar.model;

import racingcar.exception.IllegalArgumentException;

public class CarName {
    public static final int MIN_LENGTH_NAME = 1;
    public static final int MAX_LENGTH_NAME = 5;

    private final String carName;

    public CarName(String str) throws IllegalArgumentException {
        validateCarName(str);
        carName = str;
    }

    public void validateCarName(String str) throws IllegalArgumentException {
        checkCarNameMaxLength(str);
        checkCarNameMinLength(str);
    }

    private void checkCarNameMaxLength(String str) throws IllegalArgumentException {
        if (str.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(IllegalArgumentException.MSG_MAX_LENGTH_CAR_NAME);
        }
    }

    private void checkCarNameMinLength(String str) throws IllegalArgumentException {
        if (str.length() < MIN_LENGTH_NAME) {
            throw new IllegalArgumentException(IllegalArgumentException.MSG_MIN_LENGTH_CAR_NAME);
        }
    }

    public String getCarNameValue() {
        return carName;
    }
}
