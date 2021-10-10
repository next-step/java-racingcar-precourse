package racinggame.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttemptCount {
    private static final Pattern ATTEMPT_COUNT_PATTERN = Pattern.compile("[+-]?\\d*(\\.\\d+)?");

    private final int count;

    public AttemptCount(final String count) {
        attemptCountValidation(count);
        this.count = Integer.parseInt(count);
    }

    public int attemptCountValidation(String countStr) {
        final Matcher matcher = ATTEMPT_COUNT_PATTERN.matcher(countStr);
        if(!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(countStr);
    }

    public int getAttemptCount() {
        return count;
    }
}
