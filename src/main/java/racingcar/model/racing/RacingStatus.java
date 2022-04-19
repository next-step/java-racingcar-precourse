package racingcar.model.racing;

public enum RacingStatus {
    STOP,
    GO;

    public boolean isGo() {
        return this == GO;
    }
}
