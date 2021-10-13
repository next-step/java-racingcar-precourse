package racinggame.utils;

public class ValidationUtils {
    private static final int CAR_NAME_MAX_LENGTH = 5;   // 자동차 이름 가능 최대글자수

    public static boolean validateCarNameLength(String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }
}
