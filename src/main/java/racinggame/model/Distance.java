package racinggame.model;

public class Distance {
    private static final int DRIVE = 1;
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance += DRIVE;
    }

}
