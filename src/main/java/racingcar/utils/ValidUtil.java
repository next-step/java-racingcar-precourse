package racingcar.utils;

public class ValidUtil {
    public static void emptyString(String string) {
        if (string.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자는 입력할 수 없습니다");
        }
    }
}
