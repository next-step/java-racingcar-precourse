package racingcar.model;

import racingcar.global.errorcode.ErrorCode;

public class TryCount {

    private static final int MINIMUM_VALUE = 1;
    private int tryCount;

    public TryCount(String inputCount) {
        integerValidation(inputCount);
        rangeValidation(inputCount);
        tryCount = Integer.parseInt(inputCount);

    }

    public int getTryCount() {
        return tryCount;
    }

    private void integerValidation(String inputCount) {
        if (!inputCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    private void rangeValidation(String inputCount) {
        if (Integer.parseInt(inputCount) < MINIMUM_VALUE) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_MINIMUM_COUNT.getMessage());
        }
    }
}
