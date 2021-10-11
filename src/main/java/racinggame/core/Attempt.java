package racinggame.core;

public class Attempt {

    private static final int MIN_ATTEMPT = 1;

    private final int attemptNumber;

    public Attempt(final String attemptString) {
        try {
            this.attemptNumber = Integer.parseInt(attemptString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        checkValidateAttemptNumber();
    }

    public int getAttemptNumber() {
        return this.attemptNumber;
    }

    private void checkValidateAttemptNumber() {
        if (this.attemptNumber < MIN_ATTEMPT) {
            throw new IllegalArgumentException(
                String.format("시도 횟수는 최소 %d 이상이어야 합니다.", MIN_ATTEMPT)
            );
        }
    }

}
