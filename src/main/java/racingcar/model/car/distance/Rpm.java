package racingcar.model.car.distance;

import racingcar.error.Error;

public class Rpm {
    private static final int MAX_LEVEL = 9;
    private static final int MIN_LEVEL = 0;
    private final int level;

    public Rpm(int level) {
        validationCheck(level);
        this.level = level;
    }

    private void validationCheck(int checkValue) {
        if (checkValue < MIN_LEVEL || checkValue > MAX_LEVEL) {
            throw new IllegalArgumentException(Error.NOT_VALID_LEVEL.message());
        }
    }

    public static int MaxRpmLevel() {
        return MAX_LEVEL;
    }

    public static int MinRpmLevel() {
        return MIN_LEVEL;
    }

    public int level() {
        return this.level;
    }
}
