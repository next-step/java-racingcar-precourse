package racingcar;

public class TravelDistance {

    private int distance;

    public TravelDistance() {

    }

    private TravelDistance(int distance) {
        this.distance = distance;
    }

    public static TravelDistance create(int distance) {
        validDistance(distance);
        return new TravelDistance(distance);
    }

    public void increase() {
        this.distance++;
    }

    private static void validDistance(int distance) {
        if (distance < 0)
            throw new IllegalArgumentException("이동 거리가 음수일 수 없습니다.");
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
