package racingcar.car.domain.models;

public enum CarMovePolicy {
    MOVE,
    STOP;

    public boolean isMove() {
        return this == MOVE;
    }
}
