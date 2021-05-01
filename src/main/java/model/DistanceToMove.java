package model;

public class DistanceToMove {
    public static final int MIN_DISTANCE = 0;
    public static final int MAX_DISTANCE = 9;

    private final int distance;

    public DistanceToMove(int distance) {
        if (distance < MIN_DISTANCE || distance > MAX_DISTANCE) {
            throw new IllegalArgumentException("자동차가 이동할 거리는 0 ~ 9 범위만 가능합니다.");
        }
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
