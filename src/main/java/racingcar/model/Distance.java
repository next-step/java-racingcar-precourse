package racingcar.model;

public class Distance {
    private int distance = 0;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void increase() {
        this.distance += 1;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance otherDistance = (Distance) o;
        return distance == otherDistance.getDistance();
    }
}
