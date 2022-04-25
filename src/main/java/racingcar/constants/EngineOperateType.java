package racingcar.constants;

public enum EngineOperateType {
    ACCELERATE(1), BREAK(0);

    private int value;

    EngineOperateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
