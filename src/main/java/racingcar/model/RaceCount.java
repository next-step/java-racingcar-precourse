package racingcar.model;

import racingcar.common.Messages;

public class RaceCount {

    private final int count;

    public static RaceCount generate(String count) {
        validate(count);
        try {
            return new RaceCount(Integer.parseInt(count));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_RACE_COUNT.toString());
        }
    }

    private RaceCount(int count) {
        this.count = count;
    }

    public int get() {
        return count;
    }

    private static void validate(String count) {
        if (count.isEmpty() || Messages.ZERO.equals(count)) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_RACE_COUNT.toString());
        }
    }
}
