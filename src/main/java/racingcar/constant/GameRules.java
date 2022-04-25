package racingcar.constant;

public enum GameRules {
    FORWARD_CONDITION(4),
    CAR_NAME_LENGTH(5),
    ;

    GameRules(int condition) {
        this.condition = condition;
    }

    private final int condition;

    public int getCondition() {
        return condition;
    }

    public static int forwardCondition() {
        return FORWARD_CONDITION.getCondition();
    }

    public static int carNameLength() {
        return CAR_NAME_LENGTH.getCondition();
    }
}
