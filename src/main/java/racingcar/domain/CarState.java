package racingcar.domain;

public enum CarState {

    MOVING_FORWARD(4),
    STOP(3),
    ;

    private final int no;

    CarState(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
