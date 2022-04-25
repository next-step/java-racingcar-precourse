package racingcar.constant;

public enum Length {
    MIN_LENGTH(1),
    MAX_LENGTH(5);

    private int value;

    Length(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
