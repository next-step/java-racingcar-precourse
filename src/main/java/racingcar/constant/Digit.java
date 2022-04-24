package racingcar.constant;

public enum Digit {
    START_RANGE(0),
    END_RANGE(9),
    STANDARD_ENGIN(3),
    ZERO(0),
    MAX_CAR_NAME_LENGTH(5),
    STANDARD_ZERO(1);

    private final int number;

    Digit(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
