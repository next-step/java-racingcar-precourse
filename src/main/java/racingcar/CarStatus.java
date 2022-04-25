package racingcar;


import static racingcar.RacingProperties.VALUE_REFERENCE_POINT;

public enum CarStatus {
    GO, STOP;

    public static CarStatus from(int number) {
        if (number < VALUE_REFERENCE_POINT) {
            return STOP;
        }
        return GO;
    }

    public boolean isGo() {
        return this == GO;
    }
}
