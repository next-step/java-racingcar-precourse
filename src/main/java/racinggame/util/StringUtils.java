package racinggame.util;

import racinggame.code.CarConfig;
import racinggame.code.ErrorMessage;
import racinggame.exception.RacinggameException;

public class StringUtils {

    public static void validateStringLength(String inputString) {
        if (inputString.length() > CarConfig.CAR_NAME_SIZE.getValue()) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getValue());
        }
    }

    public static void validateStringNull(String inputString) {
        if (inputString == null) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_NULL.getValue());
        }
    }
}
