package racingcar.domain;

public enum MoveStatus {
    MOVE, STOP;

    public static final int MIN_NUMBER_TO_MOVE = 4;

    public static MoveStatus getStatus(RandomNumber randomNumber) {
        if (randomNumber.getNumber() >= MIN_NUMBER_TO_MOVE) {
            return MOVE;
        }
        return STOP;
    }

    public boolean isMove() {
        return this == MOVE;
    }
}
