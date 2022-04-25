package racingcar.domain;

import racingcar.exception.ui.AttemptCountEmptyException;
import racingcar.exception.ui.AttemptCountTypeException;

public class AttemptCount {
    private static final int ATTEMPT_COUNT_INIT = 0;
    private static final int ASCII_CODE_NUMBER_ZERO = 48;
    private static final int ASCII_CODE_NUMBER_NINE = 57;

    private int attemptCount;

    public AttemptCount(String attemptCountToString) {
        validateAttemptCountType(attemptCountToString);
        this.attemptCount = Integer.parseInt(attemptCountToString);
    }

    private static void validateAttemptCountType(String attemptCount) {
        if (attemptCount.isEmpty()) {
            throw new AttemptCountEmptyException();
        }

        for (int attemptCountInit = ATTEMPT_COUNT_INIT; attemptCountInit < attemptCount.length(); attemptCountInit++) {
            validateAttemptCountTypeOfNumber(attemptCount.charAt(attemptCountInit));
        }
    }

    private static void validateAttemptCountTypeOfNumber(char attemptCount) {
        if (attemptCount < ASCII_CODE_NUMBER_ZERO || attemptCount >= ASCII_CODE_NUMBER_NINE) {
            throw new AttemptCountTypeException();
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
