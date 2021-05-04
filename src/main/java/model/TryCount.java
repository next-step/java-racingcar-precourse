package model;

public class TryCount {
    public static final int ZERO = 0;
    private int count;

    public TryCount(String count) {
        this.count = Integer.parseInt(count);
    }

    public boolean isTrying() {
        return count > ZERO;
    }

    public void decreaseCount() {
        count--;
    }
}
