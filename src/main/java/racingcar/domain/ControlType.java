package racingcar.domain;

public enum ControlType {

    FORWARD(1), STOP(0);

    private final int distance;

    ControlType(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
