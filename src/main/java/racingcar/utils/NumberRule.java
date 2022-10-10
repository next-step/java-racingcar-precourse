package racingcar.utils;

public enum NumberRule {

    NAME_LENGTH_LIMIT(5),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_MOVING_FORWARD_RANDOM_NUMBER(4),
    INITIAL_POSITION(0),
    FORWARD_NUMBER(1),
    MIN_CAR_NUMBER(2),
    MIN_TRY_NUMBER(1);

    private int value;

    private NumberRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
