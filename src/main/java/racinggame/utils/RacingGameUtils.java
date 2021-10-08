package racinggame.utils;

public class RacingGameUtils {

    private static final String SPLIT_REGEX = ",";
    private static final int RACING_CAR_NAME_LENGTH_LIMIT = 5;

    public static String[] racingCarNameSplit(String racingCarNameInput) {
        return racingCarNameInput.split(SPLIT_REGEX);
    }

    public static boolean isValidRacingCarNameLength(String racingCarName) {
        if (racingCarName.length() > RACING_CAR_NAME_LENGTH_LIMIT) {
            return false;
        }
        return true;
    }

    public static String[] trim(String[] target) {
        for (int i = 0; i < target.length; i++) {
            target[i] = target[i].trim();
        }
        return target;
    }
}
