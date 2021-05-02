package racingcar;

import java.util.HashMap;
import java.util.Map;

public class TravelDistance {

    public static final TravelDistance ZERO = new TravelDistance(0);
    private static final Map<Integer, TravelDistance> store = new HashMap<>();

    private final int distance;

    private TravelDistance(int distance) {
        this.distance = distance;
    }

    public static TravelDistance create(int distance) {
        if(distance == 0)
            return ZERO;

        TravelDistance travelDistance = store.get(distance);
        if (travelDistance == null) {
            store.put(distance, new TravelDistance(distance));
            travelDistance = store.get(distance);
        }
        return travelDistance;
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
