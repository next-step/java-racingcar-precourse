package racingcar.global.validate;

import racingcar.domain.InputData;

import java.util.regex.Pattern;

public class ValidateCommon {
    private ValidateCommon() {}

    private static final Pattern NUMBER = Pattern.compile("[0-9]+");

    public static boolean isEmpty(InputData inputData) {
        return inputData.isEmpty();
    }

    public static boolean isNumber(InputData inputData) {
        return NUMBER.matcher(inputData.getInputData()).matches();
    }
}
