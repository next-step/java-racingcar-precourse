package racingcar;

public class TravelDistance {

    private int distance;

    public TravelDistance(int distance) {
        this.distance = distance;
    }

    public static TravelDistance zero() {
        return new TravelDistance(0);
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
