package racingcar.model.vo;

import racingcar.model.constants.ErrorMessage;

public class TotalRound {

    private static final int MIN_TOTAL_ROUND_COUNT = 1;
    private final int totalRound;

    public TotalRound(int number) {
        if (!validateRoundCount(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_MIN);
        }
        this.totalRound = number;
    }

    public TotalRound(String input) {
        if (!validateRoundNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_NOT_NUMBER);
        }
        int number = Integer.parseInt(input);
        if (!validateRoundCount(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_MIN);
        }
        this.totalRound = number;
    }

    protected static boolean validateRoundCount(int number) {
        return number >= MIN_TOTAL_ROUND_COUNT;
    }

    protected static boolean validateRoundNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getTotalRound() {
        return totalRound;
    }
}
