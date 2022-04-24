package racingcar.domain;

public class Condition {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    private static final int MOVABLE_CONDITION = 4;

    private final int value;

    public Condition(int value) {
        this.value = value;
    }

    public boolean isMovableCondition() {
        return value >= MOVABLE_CONDITION;
    }

    public int getValue() {
        return value;
    }

}
