package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static boolean isBlank(String str) {
        return str == null || "".equals(str);
    }

    public static String removeSpace(String str) {
        return str.trim();
    }

    public static List<String> splitStringToList(String str) {
        return Arrays.asList(str.split(","));
    }
}