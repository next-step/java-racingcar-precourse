package racingcar.common;

import java.util.regex.Pattern;

public class ValidationCheck {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String NUMBER_PATTERN = "^[0-9]*$";

    public static boolean carNamelengthValidation(String carName) {
      if (CAR_NAME_MAX_LENGTH < carName.length()) {
        return false;
      }
      return true;
    }

    public static boolean numberValidation(String value) {
      if (!Pattern.matches(NUMBER_PATTERN, value)) {
        return false;
      }
      return true;
    }
}
