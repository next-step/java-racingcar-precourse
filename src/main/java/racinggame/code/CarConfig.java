package racinggame.code;

public enum CarConfig {
    CarNameSize(5),
    ForwardCondition(3),
    NumberRangeStart(0),
    NumberRangeEnd(9);

    private final int carConfig;

    CarConfig(int carConfig) {
        this.carConfig = carConfig;
    }

    public int getValue() {
        return this.carConfig;
    }
}
