package racingcar.firstcollections;

import racingcar.utils.ValidationUtils;

public class Positive {

    public static final long MIN_VALUE = 0L;
    private static final long CONDITION_VALUE = 1L;
    private long value;

    public Positive() {
        this.value = MIN_VALUE;
    }

    public Positive(long num) {
        this.value = Math.max(num, MIN_VALUE);
    }

    public Positive(String num) {
        if (!ValidationUtils.isNumeric(num)) {
            throw new IllegalArgumentException("");
        }
        this.value = Math.max(Long.parseLong(num), MIN_VALUE);
    }

    public long get() {
        return this.value;
    }

    public void add() {
        this.value += CONDITION_VALUE;
    }

    public void sub() {
        if (this.value == MIN_VALUE) {
            return;
        }
        this.value -= CONDITION_VALUE;
    }
}
