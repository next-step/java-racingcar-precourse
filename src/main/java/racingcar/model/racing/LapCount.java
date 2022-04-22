package racingcar.model.racing;

import racingcar.model.car.CarConfig;

public class LapCount {
    private final int count;

    public LapCount(String value) {
        this.count = parseInt(value);
    }

    private int parseInt(String value) {
        validate(value);

        return Integer.parseInt(value);
    }

    private void validate(String value) {
        try {
            int lapCount = Integer.parseInt(value);
            validateIfRange(lapCount);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfRange(int lapCount) {
        if (lapCount < CarConfig.MIN_LAP_COUNT || lapCount > CarConfig.MAX_LAP_COUNT) {
            throw new NumberFormatException();
        }
    }

    public int getLapCount() {
        return count;
    }
}
