package racingcar.constant;

public class MoveRange {

    public static final int STOP_MAX = 3;
    public static final int STOP_MIN = 0;
    public static final int FORWARD_MIN = 4;
    public static final int FORWARD_MAX = 9;

    private MoveRange() {
        throw new IllegalStateException("Constant class");
    }
}
