package racingcar.util;

import java.util.regex.Pattern;

public class InputValidation {

    private static Pattern isOnlyNumber = Pattern.compile("^[0-9]*?");

    public static String[] inputLengthValidation(String input) {
        String[] inputStringSet = input.split(",");
        for (String str : inputStringSet) {
            checkLength(str);
        }
        return inputStringSet;
    }

    public static void checkLength(String str){
        if (str.length() > 5) {
            throw new IllegalArgumentException("참가자명은 5자리 이하만 가능합니다. 확인 해야할 사용자명 : " + str);
        }
    }

    public static int inputGameCountValidation(String number) {
        if (!isOnlyNumber.matcher(number).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(number);
    }
}
