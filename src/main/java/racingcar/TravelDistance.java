package racingcar;

public class TravelDistance {

    private int travelDistance;

    public void increase() {
        this.travelDistance++;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelDistance that = (TravelDistance) o;

        return travelDistance == that.travelDistance;
    }

    @Override
    public int hashCode() {
        return travelDistance;
    }
}
