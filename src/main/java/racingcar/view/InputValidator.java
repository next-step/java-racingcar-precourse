package racingcar.view;

import racingcar.contant.ExceptionMessage;

public class InputValidator {
    private static final String TRY_COUNT_REG_EXP = "^[0-9]+$";

    public static void validateCarNames(String carNames) {
        if (isEmpty(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_CAR_NAMES);
        }
    }

    public static void validateTryCount(String tryCount) {
        if (isEmpty(tryCount) || !tryCount.matches(TRY_COUNT_REG_EXP)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_TRY_COUNT);
        }
    }

    private static boolean isEmpty(String carNames) {
        return carNames == null || carNames.length() == 0;
    }
}
