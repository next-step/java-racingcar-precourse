package racingcar.firstcollections;

import racingcar.utils.ValidationUtils;

public class Positive {

    public static final long MIN_VALUE = 0L;
    private static final long CONDITION_VALUE = 1L;
    private static final String ERROR_MESSAGE = "%d 이상 숫자만 입력 가능합니다.";
    private long value;

    public Positive() {
        this.value = MIN_VALUE;
    }

    public Positive(final long num) {
        if (isNotPositive(num)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_VALUE));
        }
        this.value = num;
    }

    public Positive(final String input) {
        if (!ValidationUtils.isNumeric(input)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_VALUE));
        }
        long num = Long.parseLong(input);
        if (isNotPositive(num)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_VALUE));
        }
        this.value = num;
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

    private boolean isNotPositive(final long num) {
        return num < MIN_VALUE;
    }
}
