package racingcar.domain;

public class RoundCount {
    
    public static final int MIN_COUNT = 0;

    private final int count;
    private int current = 0;

    public RoundCount(String count) {
        validate(count);
        this.count = Integer.parseInt(count);
    }

    public void nextRound() {
        validateRound();

        current++;
    }

    public boolean hasNextRound() {
        return (current < count);
    }

    private void validate(String count) {
        if (!isNumeric(count)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_DIGIT_ERROR.getMessage());
        }

        if (isNegativeNumber(Integer.parseInt(count))) {
            throw new IllegalArgumentException(
                    ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage(MIN_COUNT));
        }
    }

    private boolean isNumeric(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        
        return true;
    }

    private boolean isNegativeNumber(int count) {
        return (count < MIN_COUNT);
    }

    private void validateRound() {
        if (!hasNextRound()) {
            throw new IllegalStateException(
                    ErrorMessage.START_ROUND_WHEN_GAME_OVER_ERROR.getMessage());
        }
    }
}
