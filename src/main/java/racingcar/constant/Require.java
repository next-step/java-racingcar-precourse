package racingcar.constant;

public enum Require {
    MIN_VALUE(0),
    MORE_THAN_CONDITION(4),
    MAX_VALUE(9);

    private int value;

    Require(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
