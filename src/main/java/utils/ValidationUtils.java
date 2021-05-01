package utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    public static boolean isBlank(String input) {
        return "".equals(input.trim());
    }

    public static boolean isDuplicated(String[] names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            set.add(name.trim());
        }

        return names.length != set.size();
    }

    public static boolean isNumber(String input) {
        return !input.matches("^[1-9]+$");
    }
}
