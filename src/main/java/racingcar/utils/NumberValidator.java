package racingcar.utils;

import racingcar.constants.ErrorMessage;

public class NumberValidator {

    public static Integer validateNumber(final String input) {
        final Integer number = toInteger(input);
        if (isLessOrEqualToZero(number)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_IS_NOT_INTEGER);
        }
        return number;
    }

    private static Integer toInteger(final String input) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_IS_NOT_INTEGER);
        }
        return number;
    }

    private static boolean isLessOrEqualToZero(final Integer input) {
        return input <= 0;
    }
}
