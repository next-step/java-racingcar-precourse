package racingcar.domain;

public class NumberRange {

    private final int min;
    private final int max;

    public NumberRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMinNumber() {
        return min;
    }

    public int getMaxNumber() {
        return max;
    }
}
