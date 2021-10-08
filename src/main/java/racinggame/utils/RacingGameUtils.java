package racinggame.utils;

public class RacingGameUtils {

    public static String[] racingCarNameSplit(String racingCarNameInput, String regex) {
        return racingCarNameInput.split(regex);
    }
}
