package racingcar.domain;

import java.util.ArrayList;

public class Distance {
    private final ArrayList<Boolean> distances = new ArrayList<>();

    public Distance() {}

    public ArrayList<Boolean> getDistances() {
        return this.distances;
    }

    public void setDistance(Boolean move) {
        distances.add(move);
    }
}
