package racingcar.racing;

import static racingcar.ErrorMessage.LAP_COUNT_NOT_NUMBER;

public class Lap {
    private static final String REGEX_LAP_INPUT = "[0-9]+";

    private final int count;

    public Lap(String count) {
        this.count = checkValidation(count);
    }

    public int getCount() {
        return count;
    }

    private int checkValidation(String count) {
        if (!count.matches(REGEX_LAP_INPUT)) {
            throw new IllegalArgumentException(LAP_COUNT_NOT_NUMBER);
        }
        return Integer.parseInt(count);
    }
}
