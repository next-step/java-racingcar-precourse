package racingcar.configuration;

public enum DirectionStatus {
    STOP, MOVE_FORWARD;

    public boolean isMoveForward() {
        return this == MOVE_FORWARD;
    }
}
