package racingcar.domain;

public class RacingRounds {
    public static final String NUMBER_FORMAT_REGEX = "^[0-9]*$";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    public static final String EQUAL_ZERO_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 0보다 커야 한다.";

    private int rounds;

    public RacingRounds(String input) {
        validateNumberFormat(input);
        validateZeroNumber(input);
        rounds = Integer.parseInt(input);
    }

    private void validateZeroNumber(String input) {
        if (isEqualZero(input)) {
            throw new IllegalArgumentException(EQUAL_ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberFormat(String input) {
        if (isNotNumberFormat(input)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isEqualZero(String input) {
        return Integer.parseInt(input) == 0;
    }

    private boolean isNotNumberFormat(String input) {
        return !input.matches(NUMBER_FORMAT_REGEX);
    }

    public void endCurrentRound() {
        rounds -= 1;
    }

    public boolean isEndGame() {
        return rounds == 0;
    }
}
