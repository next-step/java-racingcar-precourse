package nextstep.domain;

import java.util.Objects;

public class MoveResult {

    private static final String DISTANCE_TEXT = "-";

    private final String name;
    private final int distance;

    public MoveResult(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < distance; j++) {
            sb.append(DISTANCE_TEXT);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveResult that = (MoveResult) o;
        return distance == that.distance && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
