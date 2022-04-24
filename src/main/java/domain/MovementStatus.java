package domain;

public enum MovementStatus {
    FORWARD, STOP;

    public boolean isForward() {
        return this == FORWARD;
    }
}
