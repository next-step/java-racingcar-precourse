package racingcar.controller;

import org.junit.platform.commons.util.StringUtils;

import java.time.temporal.ValueRange;

public class AttemptRaceCountForm {
    public static final String ERROR_MSG_NOT_NUMBER_FORMAT = "[ERROR] 입력값은 숫자이어야 합니다.";
    public static final String ERROR_MSG_OUT_OF_RANGE = "[ERROR] 입력값의 범위는 음수일 수 없습니다";
    public static final String ERROR_MSG_BLANK_OR_NULL = "[ERROR] 입력값이 공백일 수 없습니다.";

    private final int attemptRaceCount;

    public AttemptRaceCountForm(String attemptRaceCount) {
        this.attemptRaceCount = validateRaceCount(attemptRaceCount);
    }

    private int validateRaceCount(String attemptRaceCount) {
        validateBlankOrNull(attemptRaceCount);
        int raceCount = validateNumberFormat(attemptRaceCount);
        validateRange(raceCount);
        return raceCount;
    }

    private void validateBlankOrNull(String attemptRaceCount) {
        if (StringUtils.isBlank(attemptRaceCount) || attemptRaceCount == null) {
            throw new IllegalArgumentException(ERROR_MSG_BLANK_OR_NULL);
        }
    }

    private int validateNumberFormat(String attemptRaceCount) {
        int result;
        try {
            result = Integer.parseInt(attemptRaceCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER_FORMAT);
        }
        return result;
    }

    private void validateRange(int raceCount) {
        ValueRange range = ValueRange.of(1, Integer.MAX_VALUE);
        if (!range.isValidIntValue(raceCount)) {
            throw new IllegalArgumentException(ERROR_MSG_OUT_OF_RANGE);
        }
    }

    public int getAttemptRaceCount() {
        return attemptRaceCount;
    }
}
