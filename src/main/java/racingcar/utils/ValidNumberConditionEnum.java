package racingcar.utils;

public enum ValidNumberConditionEnum {
    MAX_NAME_LENGTH(5),
    MAX_VALUE(9),
    MIN_VALUE(0),
    MOVING_FORWARD(4);

    private final int value;

    ValidNumberConditionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
