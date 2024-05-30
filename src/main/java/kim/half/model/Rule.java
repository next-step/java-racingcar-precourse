package kim.half.model;

public enum Rule {
    MIN_NUMBER(0), MAX_NUMBER(9),
    MIN_LENGTH(1), MAX_LENGTH(4), THRESHOLD(4),
    ;

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
