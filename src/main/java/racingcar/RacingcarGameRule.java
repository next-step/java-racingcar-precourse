package racingcar;

public enum RacingcarGameRule {

    MIN_LENGTH_OF_NAME(1),
    MAX_LENGTH_OF_NAME(5);

    private final int value;

    RacingcarGameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
