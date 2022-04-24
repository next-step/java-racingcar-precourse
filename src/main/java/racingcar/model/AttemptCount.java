package racingcar.model;

import racingcar.message.ErrorMessage;

import java.util.regex.Pattern;

public class AttemptCount {
    private static final Pattern pattern = Pattern.compile("^[0-9]+$");
    private static final String ZERO = "0";

    private String attemptCount;

    public AttemptCount(String attemptCount) {
        validate(attemptCount);
        this.attemptCount = attemptCount;
    }

    private static void validate(String attemptCount) {
        if (!pattern.matcher(attemptCount).find()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() +
                    ErrorMessage.ONLY_NUMBER_ATTEMPT_COUNT_ERROR.getMessage());
        }

        if (ZERO.equals(attemptCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() +
                    ErrorMessage.MORE_THAN_ZERO_ATTEMPT_COUNT_ERROR.getMessage());
        }
    }

    public int getAttemptCount() {
        return Integer.parseInt(attemptCount);
    }
}
