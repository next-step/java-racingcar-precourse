package racingcar.domain;

public class Engine {
    
    private static final int MIN_FORWARD_ACCEL = 4;

    public Move accel(AccelValue accelValue) {
        if (accelValue.isLowerThan(MIN_FORWARD_ACCEL)) {
            return Move.STOP;
        }
        if (accelValue.isEqualOrGreaterThan(MIN_FORWARD_ACCEL)) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
