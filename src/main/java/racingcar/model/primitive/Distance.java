package racingcar.model.primitive;

public class Distance {
    private Integer distance;

    public Distance(int value) {
        this.distance = value;
    }

    public int getValue() {
        return distance;
    }

    public void add() {
        this.distance++;
    }
}
