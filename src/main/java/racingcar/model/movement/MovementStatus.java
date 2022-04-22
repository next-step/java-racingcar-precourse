package racingcar.model.movement;

public enum MovementStatus {
    STOP,
    GO;

    public boolean isGo() {
        return this == GO;
    }
}
