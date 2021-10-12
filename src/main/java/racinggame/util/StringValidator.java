package racinggame.util;

import racinggame.code.CarConfig;
import racinggame.code.ErrorMessage;
import racinggame.exception.RacinggameException;

public class StringValidator {

    public static void validateStringLength(String inputString) {
        if (inputString.length() > CarConfig.CarNameSize.getCarConfig()) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getErrorMessage());
        }
    }

    public static void validateStringNull(String inputString) {
        if (inputString == null) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_NULL.getErrorMessage());
        }
    }
}
