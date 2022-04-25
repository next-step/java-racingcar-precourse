package racingcar.utils;

public class DrivingCondition {

    private DrivingCondition() {
    }

    public static final int SMALLEST_MOVEABLE_NUMBER = 4;

    public static boolean isPossible(int input) {
        return input >= SMALLEST_MOVEABLE_NUMBER;
    }
}
