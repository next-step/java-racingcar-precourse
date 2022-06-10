package racingcar.util;

public class StringUtil {

    public static String VALIDATE_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    public static String COMMA = ",";
    public StringUtil() {
    }

    public  static boolean isBlank(String value) {
        if(value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static String[] splitText(String value) {
        if (isBlank(value) || !value.contains(COMMA)) {
            throw new IllegalArgumentException(VALIDATE_ERROR_MESSAGE);
        }
        return value.replace(" ", "").split(",");
    }
}
