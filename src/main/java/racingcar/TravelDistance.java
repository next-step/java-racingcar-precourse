package racingcar;

public class TravelDistance {

    private static final TravelDistanceStore store = new TravelDistanceStore();

    private final int distance;

    protected TravelDistance(int distance) {
        this.distance = distance;
    }

    public static TravelDistance create(int distance) {
        if (store.isEmpty(distance))
            store.add(distance);

        return store.get(distance);
    }

    public TravelDistance increase() {
        return create(getNextDistance());
    }

    private int getNextDistance() {
        return distance + 1;
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
