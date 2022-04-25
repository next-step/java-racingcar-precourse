package racingcar;

import static racingcar.RacingMessage.*;

public class ValidUtils {

    public static final int COMPARE_LENGTH = 5;

    public static void validLength(String str) {
        if (str == null  || str.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY);
        }

        if (str.length() > COMPARE_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_ERROR_OVER_LENGTH);
        }
    }

    public static void validNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NUMBER_FORMAT);
        }
    }

}
