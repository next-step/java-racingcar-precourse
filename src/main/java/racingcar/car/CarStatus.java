package racingcar.car;

public enum CarStatus {
    NEXT, STOP;

    public boolean isNext() {
        return this == NEXT;
    }
}
