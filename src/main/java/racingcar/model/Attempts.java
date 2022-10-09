package racingcar.model;

public class Attempts {
    private static final String ERROR_INVALID_FORMAT = "시도 횟수는 양의 정수만 가능합니다.";
    private int count;

    public Attempts(String input) {
        validateAndSetAttempts(input);
    }

    private void validateAndSetAttempts(String input) {
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
    }

    public int getCount() {
        return count;
    }
}
