package util;

public class SplitingCarName {
    private static final String STRING_SPLITTER = ",";

    public static String[] splitCarName(String carNames) {
        return carNames.split(STRING_SPLITTER);
    }
}
