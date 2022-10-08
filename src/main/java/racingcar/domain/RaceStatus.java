package racingcar.domain;

public enum RaceStatus {
    LOSE, WINNE;

    public boolean isLose() {
        return this == RaceStatus.LOSE;
    }

}
