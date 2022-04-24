package racingcar.rule;

import java.util.Objects;

public class Condition implements Comparable<Condition>{

    static final int MIN = 0;
    static final int MAX = 9;

    private final int value;

    protected Condition(int value) {
        validate(value);
        this.value = value;
    }

    public static Condition of(int value) {
        return new Condition(value);
    }

    private static void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidConditionException();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Condition that = (Condition) o;
        return value == that.value;
    }

    @Override
    public int compareTo(Condition other) {
        return Integer.compare(value, other.value);
    }
}
