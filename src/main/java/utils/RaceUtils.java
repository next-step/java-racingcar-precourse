package utils;

import nextstep.utils.Randoms;

public class RaceUtils {
    private RaceUtils() {
    }

    public static final String COMMA = ",";

    public static String[] splitStringByComma(String input) {
        return input.split(COMMA);
    }

    public static int randomNumber(int randomMin, int randomMax) {
        return Randoms.pickNumberInRange(randomMin, randomMax);
    }
}
