package racingcar.common;

import java.util.regex.Pattern;

public class ValidationCheck {
    public static int CAR_NAME_MAX_LENGTH = 5;

    public static boolean carNamelengthValidation(String carName) {
        if (CAR_NAME_MAX_LENGTH < carName.length()) {
            return false;
        }
        return true;
    }
}
