package racingcar.domain.move;

public enum MoveType {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }
}
