package racingcar.constant;

public enum RandomRules {
    MIN(0),
    MAX(9)
    ;

    RandomRules(int condition) {
        this.condition = condition;
    }

    private final int condition;

    public int getCondition() {
        return condition;
    }

    public static int minCondition() {
        return MIN.getCondition();
    }

    public static int maxCondition() {
        return MAX.getCondition();
    }
}
