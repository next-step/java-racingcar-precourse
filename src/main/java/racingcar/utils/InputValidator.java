package racingcar.utils;

import static racingcar.utils.Constants.ERROR_ILLEGAL_NUMBER_INPUT;

public class InputValidator {
    public static void isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX+ERROR_ILLEGAL_NUMBER_INPUT);
        }
    }

    public static void isNumberInRange(String value) {
        int inputNumber = Integer.parseInt(value);
        if(inputNumber <= Constants.RANDOM_MIN_NUMBER) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX+Constants.ERROR_ILLEGAL_RANGE_NUMBER_INPUT);
        }
    }
}
