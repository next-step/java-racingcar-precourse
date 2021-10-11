package racinggame;

public class RaceManagerCurrentCount {
    private int currentCount;

    public RaceManagerCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void increaseCount() {
        currentCount++;
    }
}
