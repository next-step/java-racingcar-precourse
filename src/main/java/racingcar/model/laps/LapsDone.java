package racingcar.model.laps;

public class LapsDone {
    private int lapsDone;

    public LapsDone() {
        this.lapsDone = 0;
    }

    public int get() {
        return lapsDone;
    }

    public void add() {
        lapsDone++;
    }
}
