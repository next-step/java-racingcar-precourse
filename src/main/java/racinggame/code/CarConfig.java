package racinggame.code;

public enum CarConfig {
    CAR_NAME_SIZE(5),
    FORWARD_CONDITION(3),
    NUMBER_RANGE_START(0),
    NUMBER_RANGE_END(9),
    CAR_LIST_MIN_SIZE(2);

    private final int carConfig;

    CarConfig(int carConfig) {
        this.carConfig = carConfig;
    }

    public int getValue() {
        return this.carConfig;
    }
}
