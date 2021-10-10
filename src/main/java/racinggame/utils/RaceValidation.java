package racinggame.utils;

import racinggame.exception.ErrorCode;
import racinggame.exception.RaceGameException;

import static racinggame.constants.RaceGameConstants.*;

public class RaceValidation {

    public static void validateEmptyName(String name) {
        if (name == null || name.length() == 0) {
            throw new RaceGameException(ErrorCode.EMPTY_NAME);
        }
    }

    public static void validateLengthOverName(String name) {
        if (name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            throw new RaceGameException(ErrorCode.LENGTH_OVER_NAME);
        }
    }

    public static void validateNumberMatch(String tryCount) {
        boolean matches = NUMBER_PATTERN.matcher(tryCount).matches();
        if (!matches) {
            throw new RaceGameException(ErrorCode.INVALID_TEXT);
        }
        if (Integer.parseInt(tryCount) == 0) {
            throw new RaceGameException(ErrorCode.EMPTY_COUNT);
        }
    }

}
