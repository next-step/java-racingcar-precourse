package racingcar.utils;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_COIN_TYPE_POSITIVE;

public class ConvertUtil {

    public static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_COIN_TYPE_POSITIVE);
        }
    }

    public static int convertStringToInteger(String input) {
        validateIntegerType(input);
        return Integer.parseInt(input);
    }

}
