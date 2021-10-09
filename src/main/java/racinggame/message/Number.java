package racinggame.message;

public enum Number {

    RANDOM_MIN_VALUE(1),
    RANDOM_MAX_VALUE(9),

    ADVANCE_VALUE(4),

    MIN_VALUE(0);


    private int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
