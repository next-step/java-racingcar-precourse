package domain;

public class ValidationUtils {
    public static final int MOVEMENT_CONDITION_MIN = 0;
    public static final int MOVEMENT_CONDITION_MAX = 9;

    public static final int MOVEMENT_STOP_CONDITION_MIN = 0;
    public static final int MOVEMENT_STOP_CONDITION_MAX = 3;

    public static final int CAR_NAME_LENGTH_MIN = 1;
    public static final int CAR_NAME_LENGTH_MAX = 5;

    public static boolean validateMovementCondition(int number) {
        return MOVEMENT_CONDITION_MIN <= number
                && number <= MOVEMENT_CONDITION_MAX;
    }

    public static boolean validateStopCondition(int condition) {
        return MOVEMENT_STOP_CONDITION_MIN <= condition
                && condition <= MOVEMENT_STOP_CONDITION_MAX;
    }

    public static boolean validateCarNameLength(String name) {
        return name != null &&
                CAR_NAME_LENGTH_MIN <= name.length() &&
                name.length() <= CAR_NAME_LENGTH_MAX;
    }

    public static boolean validatePositiveNumber(int number) {
        return number > 0;
    }
}
