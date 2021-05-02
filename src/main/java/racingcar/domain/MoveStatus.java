package racingcar.domain;

public enum MoveStatus {
    MOVE, STOP;

    public static final int MIN_NUMBER_TO_MOVE = 4;

    public static MoveStatus getStatus(RandomNumber randomNumber) {
        return randomNumber.getNumber() >= MIN_NUMBER_TO_MOVE ? MOVE : STOP;
    }
}
