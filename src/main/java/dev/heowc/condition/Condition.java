package dev.heowc.condition;

import java.util.Objects;

public final class Condition implements Comparable<Condition> {

    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    private Condition(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidConditionException();
        }
    }

    public static Condition of(int value) {
        return new Condition(value);
    }

    @Override
    public int compareTo(Condition other) {
        return Integer.compare(value, other.value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Condition condition = (Condition) other;
        return value == condition.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
