package racinggame.utils;

public class RacingGameUtils {
    public static final String SPLIT_REGEX = ",";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final int RACING_CAR_NAME_LENGTH_LIMIT = 5;

    public static String[] racingCarNameSplit(String racingCarNameInput) {
        return racingCarNameInput.split(SPLIT_REGEX);
    }

    public static void isValidRacingCarNameLengthLimit(String racingCarName) {
        if (racingCarName.length() > RACING_CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static String[] trim(String[] target) {
        for (int i = 0; i < target.length; i++) {
            target[i] = target[i].trim();
        }
        return target;
    }
}
