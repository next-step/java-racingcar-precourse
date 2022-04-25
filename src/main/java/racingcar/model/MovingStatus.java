package racingcar.model;

public enum MovingStatus {
    GO, STOP;

    public boolean isGoing() {
        return this == GO;
    }

    public boolean isStopping() {
        return this == STOP;
    }
}
