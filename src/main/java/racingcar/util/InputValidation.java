package racingcar.util;

public class InputValidation {
    public static String[] inputLengthValidation(String input) {
        String[] inputStringSet = input.split(",");
        for (String str : inputStringSet) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("참가자명은 5자리 이하만 가능합니다. 확인 해야할 사용자명 : " + str);
            }
        }
        return inputStringSet;
    }

}
