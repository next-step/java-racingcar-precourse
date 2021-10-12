package racinggame.type;

public enum MovingStatus {
    FORWARD,
    STOP;

    public static MovingStatus of(int moving) {
        if (moving >= 4) {
            return FORWARD;
        }
        return STOP;
    }

    public static boolean isForward(MovingStatus status) {
        return FORWARD.equals(status);
    }

    public static boolean isStop(int movingValue) {
        return movingValue <= 3;
    }
}
