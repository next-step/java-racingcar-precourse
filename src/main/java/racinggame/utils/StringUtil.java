package racinggame.utils;

public class StringUtil {

    public static boolean hasText(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean isNumeric(String str) {
        if (!hasText(str)) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
