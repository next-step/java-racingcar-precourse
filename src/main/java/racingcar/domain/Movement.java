package racingcar.domain;

public class Movement {
    private int distance = 0;

    public void moving() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}

