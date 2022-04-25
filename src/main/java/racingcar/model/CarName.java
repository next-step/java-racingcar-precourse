package racingcar.model;

import racingcar.exception.IllegalArgumentException;

public class CarName {
    public static final int MAX_LENGTH_NAME = 5;
    public static final int MIN_LENGTH_NAME = 1;

    public static final String MAX_LENGTH_CAR_NAME_ERROR_MSG = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    public static final String MIN_LENGTH_CAR_NAME_ERROR_MSG = "[ERROR] 자동차 이름은 1자 이상이여야 합니다.";

    private final String carName;

    public CarName(String value) throws IllegalArgumentException {
        validateCarName(value);
        carName = value;
    }

    public void validateCarName(String value) throws IllegalArgumentException {
        boolean isValid = checkCarNameMaxLength(value) && checkCarNameMinLength(value);
    }

    private boolean checkCarNameMaxLength(String value) throws IllegalArgumentException {
        if (value.length() > MAX_LENGTH_NAME) {
            throw IllegalArgumentException.OVER_THE_MAX_LENGTH_CAR_NAME;
        }

        return true;
    }

    private boolean checkCarNameMinLength(String value) throws IllegalArgumentException {
        if (value.length() < MIN_LENGTH_NAME) {
            throw IllegalArgumentException.LESS_THAN_MIN_LENGTH_CAR_NAME;
        }

        return true;
    }

    public String getCarNameValue() {
        return carName;
    }
}
