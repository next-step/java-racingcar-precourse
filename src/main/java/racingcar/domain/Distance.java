package racingcar.domain;

public class Distance {
    private final int MOVE_UNIT = 1; // 이동 단위
    private int distance;
    private int maxDistance;

    public Distance(int maxDistance) {
        this.maxDistance = maxDistance;
        this.distance = 0;
    }

    public void increase() {
        if (isPossible())
            distance += MOVE_UNIT;
    }

    private boolean isPossible() {
        return distance != maxDistance;
    }

    public int getDistance(){
        return this.distance;
    }
}
