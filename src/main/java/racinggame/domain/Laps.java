package racinggame.domain;

public class Laps {
    private int currentLaps;
    private int laps;

    public Laps(int laps) {
        this.laps = laps;
        this.currentLaps = 1;
    }

    public int getLaps() {
        return laps;
    }

    public boolean isGoal() {
        return currentLaps > laps;
    }

    public void passStartLine() {
        currentLaps++;
    }
}
