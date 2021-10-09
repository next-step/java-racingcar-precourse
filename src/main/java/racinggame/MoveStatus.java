package racinggame;

public enum MoveStatus {
    MOVE_FORWARD,
    STOP;

    public boolean isMoveForward() {
        return this == MOVE_FORWARD;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
