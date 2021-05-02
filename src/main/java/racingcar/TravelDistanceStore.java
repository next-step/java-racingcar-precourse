package racingcar;

import java.util.HashMap;
import java.util.Map;

public class TravelDistanceStore {
    private final Map<Integer, TravelDistance> store;

    public TravelDistanceStore() {
        this.store = new HashMap<>();
    }

    public boolean isEmpty(int distance) {
        return store.get(distance) == null;
    }

    public void add(int distance) {
        store.put(distance, new TravelDistance(distance));
    }

    public TravelDistance get(int distance) {
        return store.get(distance);
    }
}
