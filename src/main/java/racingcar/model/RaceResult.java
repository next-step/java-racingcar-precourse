package racingcar.model;

import java.util.Objects;

public class RaceResult implements Comparable<RaceResult>{
    private static final String DISTANCE_CHARACTER = "-";
    private CarName carName;
    private Distance distance;

    public RaceResult(String name, int distance) {
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    @Override
    public String toString() {
        return this.printRaceResult();
    }

    @Override
    public int compareTo(RaceResult o) {
        if (this.getDistance() > o.getDistance()) {
            return 1;
        }
        if (this.getDistance() == o.getDistance()) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceResult that = (RaceResult) o;
        return Objects.equals(this.getCarName(), that.getCarName()) && Objects.equals(this.getDistance(), that.getDistance());
    }

    private String printRaceResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName.getName());
        sb.append(" : ");
        makeDistanceView(sb, distance.getDistance());
        return sb.toString();
    }

    private void makeDistanceView(StringBuilder sb, int distance) {
        for (int i=0; i<distance; i++) {
            sb.append(DISTANCE_CHARACTER);
        }
    }
}
