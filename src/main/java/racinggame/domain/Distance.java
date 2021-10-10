package racinggame.domain;

public class Distance {
    private int value;

    public Distance(final int value) {
        this.value = value;
    }

    public void forwardDistance() {
       this.value += 1;
    }

    public int getDistance() {
        return value;
    }
}
