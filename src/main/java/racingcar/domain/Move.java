package racingcar.domain;

public class Move {

    private int distance;

    public Move() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void goDistance() {
        distance++;
    }
}
