package racingcar;

public enum RaceStatus {
    INIT,
    CAR_READY,
    LAP_READY,
    RACE_READY,
    RACE_END;

    public boolean isCarReady() {
        return this.equals(CAR_READY);
    }

    public boolean isLapReady() {
        return this.equals(LAP_READY);
    }

    public boolean isRaceReady() {
        return this.equals(RACE_READY);
    }
}
