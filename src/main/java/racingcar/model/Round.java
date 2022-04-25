package racingcar.model;

import racingcar.util.ValidationUtils;

public class Round {
    private static final String ROUND_GO_ERROR_MESSAGE = "남은 시도 횟수는 0입니다.";
    private static final String ROUND_EMPTY_ERROR_MESSAGE = "시도 횟수는 필수값입니다.";
    private static final String ROUND_RANGE_ERROR_MESSAGE = "시도 횟수는 1-2147483647 사이 숫자만 가능합니다.";

    private int round;

    public Round(String numAsText) {
        validateEmpty(numAsText);
        validateNumeric(numAsText);
        validateIsInRange(numAsText);
        int round = Integer.parseInt(numAsText);
        if (round < 1) {
            throw new IllegalArgumentException(ROUND_RANGE_ERROR_MESSAGE);
        }
        this.round = round;
    }

    public boolean isOver() {
        if (round <= 0) {
            return true;
        }
        return false;
    }

    public void go() {
        if (round <= 0) {
            throw new IllegalStateException(ROUND_GO_ERROR_MESSAGE);
        }
        this.round -= 1;
    }

    private void validateEmpty(String numAsText) {
        boolean empty = ValidationUtils.isEmpty(numAsText);
        if (empty) {
            throw new IllegalArgumentException(ROUND_EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateNumeric(String numAsText) {
        boolean numeric = ValidationUtils.isNumeric(numAsText);
        if (!numeric) {
            throw new IllegalArgumentException(ROUND_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateIsInRange(String numAsText) {
        boolean inRange = ValidationUtils.isInRange(numAsText);
        if (!inRange) {
            throw new IllegalArgumentException(ROUND_RANGE_ERROR_MESSAGE);
        }
    }
}
