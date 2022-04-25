package racingcar;

public class RacingCarStatus implements Comparable<RacingCarStatus> {

    private int distance;

    private static final String MOVE_STATUS_SYMBOL = "-";

    public void move() {
        this.distance++;
    }

    @Override
    public int compareTo(RacingCarStatus racingCarStatus) {
        return Integer.compare(this.distance, racingCarStatus.distance);
    }

    @Override
    public String toString() {
        if (distance == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(MOVE_STATUS_SYMBOL);
        }
        return stringBuilder.toString();
    }
}
