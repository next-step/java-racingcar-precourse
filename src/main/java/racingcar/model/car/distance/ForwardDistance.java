package racingcar.model.car.distance;

public class ForwardDistance {
    private static final String PER_DISTANCE = "-";
    private static final int INIT_DISTANCE = 0;
    private static final int CAN_MOVE_STANDARD = 4;
    private final StringBuilder currentDistance = new StringBuilder();

    public ForwardDistance() {
        this(INIT_DISTANCE);
    }

    public ForwardDistance(int distance) {
        while (distance > INIT_DISTANCE) {
            currentDistance.append(PER_DISTANCE);
            distance--;
        }
    }

    public void hitFrom(Rpm rpm) {
        if (canIncreaseOn(rpm)) {
            currentDistance.append(PER_DISTANCE);
        }
    }

    private boolean canIncreaseOn(Rpm rpm) {
        return rpm.level() >= CAN_MOVE_STANDARD;
    }

    public String distance() {
        return currentDistance.toString();
    }

    public boolean isLongerThan(ForwardDistance forwardDistance) {
        return this.currentDistance.length() > forwardDistance.distance().length();
    }

    public boolean isSameDistanceWith(ForwardDistance forwardDistance) {
        return this.currentDistance.length() == forwardDistance.distance().length();
    }
}
