package racingcar.domain;

public class Distance {
    private int value = 0;


    public int getValue() {
        return value;
    }

    public void addDistance() {
        value++;
    }

    public boolean faterThan(Distance distance) {
        return value > distance.getValue();
    }

    public boolean faterThanEqual(Distance distance) {
        return value >= distance.getValue();
    }
}
