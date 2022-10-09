package racingcar.model;

public enum MovementAction {
    MOVE, STOP;

    public boolean isMoving() {
        return this == MovementAction.MOVE;
    }
}
