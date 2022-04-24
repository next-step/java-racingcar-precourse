package racingcar.domain;

import racingcar.service.InputValidator;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;

    private final int tryCount;

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount of(final String tryCountInput) {
        final int tryCount = InputValidator.validateTryCountInput(tryCountInput);
        validateTryCount(tryCount);
        return new TryCount(tryCount);
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_LESS_THAN_MIN.getMessage());
        }
    }

    public int getTryCount() {
        return tryCount;
    }

}
