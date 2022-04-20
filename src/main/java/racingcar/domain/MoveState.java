package racingcar.domain;

public enum MoveState {
    IDLE(Distance.valueOf(0)), FORWARD(Distance.valueOf(1));

    private Distance distance;

    MoveState(Distance distance) {
        this.distance = distance;
    }

    public Distance getDistance() {
        return distance;
    }

    public static boolean isIdle(int factor) {
        return factor <= 3;
    }
}
