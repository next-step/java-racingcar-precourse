package racingcar.model;

public class MovingRule {
    public static final int MOVING_STANDARD_NUMBER = 4;

    public MovingStatus behave(int i) {
        if ( i < MOVING_STANDARD_NUMBER) {
            return MovingStatus.STOP;
        }
        return MovingStatus.GO;
    }
}
