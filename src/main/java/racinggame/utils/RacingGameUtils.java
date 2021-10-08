package racinggame.utils;

public class RacingGameUtils {

    private static final String SPLIT_REGEX = ",";

    public static String[] racingCarNameSplit(String racingCarNameInput) {
        return racingCarNameInput.split(SPLIT_REGEX);
    }

    public static boolean isValidRacingCarNameLength(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            if (racingCarName.trim().length() > 5) {
                return false;
            }
        }
        return true;
    }
}
