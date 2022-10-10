package racingcar.utils;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_RACING_CAR_NAME_NOT_NULL_OR_EMPTY;

public class StringUtil {

    public static boolean isNullOrEmpty(String input) {
        return input.isEmpty();
    }

    public static void validateNullAndEmpty(boolean isNullOrEmpty) {
        if (isNullOrEmpty) throw new IllegalArgumentException(ERROR_RACING_CAR_NAME_NOT_NULL_OR_EMPTY);
    }
}
