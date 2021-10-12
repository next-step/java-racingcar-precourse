package racinggame.domain;

import static racinggame.domain.GameConfig.TRY_COUNT_MIN_VALUE;
import static racinggame.domain.GameErrorMessage.ERROR_TRY_COUNT_GREATER_THAN_ZERO;
import static racinggame.domain.GameErrorMessage.ERROR_TRY_COUNT_ONLY_NUMBER;

public class TryCount {
    private int tryCount;

    public TryCount(String readLine) {
        validateTryCount(readLine);
        this.tryCount = Integer.parseInt(readLine);
    }

    public int getTryCount() {
        return tryCount;
    }

    public void validateTryCount(String readLine) {
        isValidOnlyNumber(readLine);
        isValidTryCountGreaterThanZero(readLine);
    }

    public void isValidOnlyNumber(String readLine) {
        try {
            Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_TRY_COUNT_ONLY_NUMBER.getErrorMessage());
        }
    }

    public void isValidTryCountGreaterThanZero(String readLine) {
        if (Integer.parseInt(readLine) < TRY_COUNT_MIN_VALUE.getValue()) {
            System.out.println(ERROR_TRY_COUNT_GREATER_THAN_ZERO.getErrorMessage());
            throw new IllegalArgumentException(ERROR_TRY_COUNT_GREATER_THAN_ZERO.getErrorMessage());
        }
    }
}
