package homework.racegame.util;

public class ValidationChecker {

    public static boolean isValidTryCount(String times) {
        int length = times.length();
        String replace = times.replaceAll("[^0-9]", "");
        if (length == replace.length()) {
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
        return result;
    }
}
