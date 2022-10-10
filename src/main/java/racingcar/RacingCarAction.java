package racingcar;

public enum RacingCarAction {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }
}
