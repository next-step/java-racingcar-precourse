package racingcar.domain;

import racingcar.common.ErrorMessage;

public class PlayingCount {
    private static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    private static final String NUMBER_ZERO = "0";
    private final Integer count;

    public PlayingCount(String inputCount) {
        this.count = validate(inputCount);
    }

    private Integer validate(String inputCount) {
        if (isEmpty(inputCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAYING_COUNT_EMPTY);
        }
        if (!isPositiveNumber(inputCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAYING_COUNT_RANGE);
        }
        try {
            return Integer.parseInt(inputCount);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAYING_COUNT_MAX);
        }

    }

    private boolean isPositiveNumber(String inputCount) {
        return inputCount.matches(POSITIVE_NUMBER_REGEX) && !NUMBER_ZERO.equals(inputCount);
    }

    private boolean isEmpty(String inputCount) {
        return inputCount == null || inputCount.trim().length() == 0;
    }

    public Integer getCount() {
        return this.count;
    }
}
