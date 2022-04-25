package racingcar.model;

public class Distance implements Comparable<Distance>{
    public static final String DISTANCE_SHAPE = "-";

    private int distance;
    public Distance() {
        this.distance = 0;
    }

    public void increase() {
        distance++;
    }

    public String toStringDistanceShape() {
        StringBuilder scoreboard = new StringBuilder();
        for (int i=0; i < distance; i++) {
            scoreboard.append(DISTANCE_SHAPE);
        }

        return scoreboard.toString();
    }

    public int getDistanceValue() {
        return distance;
    }

    @Override
    public int compareTo(Distance o) {
        return Integer.compare(distance, o.getDistanceValue());
    }
}
