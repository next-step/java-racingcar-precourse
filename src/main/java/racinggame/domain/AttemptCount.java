package racinggame.domain;

import racinggame.config.ErrorMessage;

public class AttemptCount {

    private final int count;

    public AttemptCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_ATTEMPT_COUNT.getValue());
        }
    }

    public int getCount() {
        return count;
    }
}
