package racingcar.model.lap;

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
        if (lapCount < LapConfig.MIN_LAP_COUNT || lapCount > LapConfig.MAX_LAP_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return count;
    }
}
