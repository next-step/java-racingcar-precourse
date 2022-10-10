package racingcar.domain;

public enum Move {
    FORWARD(1),
    STOP(0),
    ;

    private final int additionalPosition;

    Move(int additionalPosition) {
        this.additionalPosition = additionalPosition;
    }

    public int getAdditionalPosition() {
        return this.additionalPosition;
    }
}
