package utils;

public class RaceUtils {

    public static final String COMMA = ",";

    public static String[] splitStringByComma(String input) {
        return input.split(COMMA);
    }
}
