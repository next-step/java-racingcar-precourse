package racingcar.domain;

public class Distance {
    public static final int INITIAL_DISTANCE = 0;
    private int distance;

    public Distance() {
        this.distance = INITIAL_DISTANCE;
    }

    public void go() {
        distance++;
    }

    public void stop() {
        //do nothing
    }

    public int get() {
        return distance;
    }

    public int compare(Distance distance) {
        return Integer.compare(this.distance, distance.get());
    }
}
