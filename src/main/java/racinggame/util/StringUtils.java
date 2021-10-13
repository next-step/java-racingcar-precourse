package racinggame.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

    public static void validateStringOnlyNumber(String inputString) {
        Pattern isNumber = Pattern.compile("^[1-9]*?");
        if (!isNumber.matcher(inputString).matches()) {
            throw new RacinggameException(ErrorMessage.INVALID_INPUT_ROUND.getValue());
        }
    }

    public static List<String> parseString(String inputString) {
        return new ArrayList<>(Arrays.asList(inputString.split(",")));
    }

    public static String combinationString(List<String> inputStringList) {
        if (inputStringList.size() > 1) {
            return String.join(",", inputStringList);
        }

        return inputStringList.get(0);
    }
}
