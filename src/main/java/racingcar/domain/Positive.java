package racingcar.domain;

public class Positive {
    private Number value;

    public Positive() {
        this(0);
    }

    public Positive(final int value) {
        this.value = value;
        validateGreaterThanOrEqualToZero();
    }

    public Positive(final String text) {
        this.value = new StringAsNumber(text);
        validateGreaterThanOrEqualToZero();
    }

    public void plus() {
        this.value = this.value.intValue() + 1;
    }

    public int intValue() {
        return this.value.intValue();
    }

    private void validateGreaterThanOrEqualToZero() {
        if (this.value.intValue() < 0) {
            throw new IllegalArgumentException("0 보다 큰 수를 입력해야 합니다.");
        }
    }
}
