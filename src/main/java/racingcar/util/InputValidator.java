package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    static final private String ERROR_TRY_TIME_TYPE = "시도 횟수는 숫자여야 합니다.";
    static final private String ERROR_TRY_TIME_POSITIVE = "시도 횟수는 양수여야 합니다.";
    static final private String ERROR_CAR_NAME_FORMAT = "자동차의 이름 입력 형태 오류 (이름은 쉼표(,) 기준으로 빈값 불가)";


    public static void validateCarNamesString(String input) {
        List<String> inputCars = Arrays.asList(input.split(","));
        if (inputCars.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_FORMAT);
        }
    }

    public static void validateTryTime(String input) {
        validateTryTimeIsInteger(input);
        validateTryTimeIsPositive(input);
    }

    private static void validateTryTimeIsPositive(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ERROR_TRY_TIME_POSITIVE);
        }
    }

    private static void validateTryTimeIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_TRY_TIME_TYPE);
        }
    }
}
