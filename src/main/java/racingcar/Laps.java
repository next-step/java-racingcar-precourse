package racingcar;

public class Laps {
    private int lap;
    public static final int MIN_LAP_COUNT = 0;

    public Laps() {
        lap = MIN_LAP_COUNT;
    }

    public Laps(int lap_count) {
        validate(lap_count);
        lap = lap_count;
    }

    private void validate(int lap_count) {
        if (lap_count < MIN_LAP_COUNT) {
            throw new IllegalArgumentException("Laps 음수 에러.");
        }
    }

    public int getNumericLap() {
        return lap;
    }

    public void setNumericLap(int lap_count) {
        validate(lap_count);
        lap = lap_count;
    }

    public void setLaps(Laps otherLaps) {
        lap = otherLaps.getNumericLap();
    }

    public void decrease() {
        if (lap > MIN_LAP_COUNT) {
            lap--;
        }
    }

    public boolean hasRemainingLaps() {
        if (lap > MIN_LAP_COUNT) {
            return true;
        }
        return false;
    }
}
