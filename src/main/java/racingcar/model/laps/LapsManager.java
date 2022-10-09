package racingcar.model.laps;

public class LapsManager {
    private final Laps laps;
    private final LapsDone lapsDone;

    public LapsManager(Laps laps) {
        this.laps = laps;
        this.lapsDone = new LapsDone();
    }

    public int getCurrentLaps() {
        return lapsDone.get();
    }

    public void next() {
        if (this.isFinished()) {
            throw new IllegalStateException();
        }
        lapsDone.add();
    }

    public boolean isFinished() {
        return lapsDone.get() >= laps.get();
    }
}
