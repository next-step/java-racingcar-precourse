package homework.racegame.util;

public class ValidationChecker {

    public static boolean isValidTryCount(String times) {
        int length = times.length();
        String replace = times.replaceAll("[^0-9]", "");
        if (length != 0 && length == replace.length()) {
            return true;
        }
        System.out.println("숫자만 입력하세요.");
        return false;
    }

    public static boolean isValidCarName(String[] carNames) {
        boolean result = true;
        for (int index = 0; index < carNames.length; index++) {
            result = result & carNames[index].length() <= 5;
        }
        if (!result) {
            System.out.println("이름이 5자리가 넘어가는 차 이름이 존재합니다. 다시 입력해주세요.");
        }
        return result;
    }
}
