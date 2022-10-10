package racingcar.utils;

import java.util.regex.Pattern;

public final class PatternUtils {
    private static final Pattern specialPattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>~]");
    private static final Pattern numericPattern = Pattern.compile("(^[0-9]*$)");

    public static boolean containSpecialCharacter(String paragraph) {
        return specialPattern.matcher(paragraph).find();
    }

    public static boolean containOnlyDigit(String paragraph) {
        return numericPattern.matcher(paragraph).find();
    }
}
