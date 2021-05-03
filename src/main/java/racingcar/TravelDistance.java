package racingcar;

public class TravelDistance {

    private int distance;

    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelDistance that = (TravelDistance) o;

        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
