package racinggame.common;

import static racinggame.common.Constant.*;

public class ValidationUtils {

    public static boolean validName(String name) {
        if(name.length() <= MAX_NAME_LEN) {
            return true;
        }
        return false;
    }

    public static boolean validTryNo(String tryNo) {
        if(tryNo.length() == 0) {
            return false;
        }

        for(char c : tryNo.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        if(Integer.parseInt(tryNo) < 0) {
            return false;
        }

        return true;
    }

    public static boolean validRandomValue(int val) {
        if(val >= MIN_NUM && val <= MAX_NUM) {
            return true;
        }
        return false;
    }

    public static boolean validCarNames(String carNames) {
        String[] names = carNames.split(NAME_REGEX);
        if(names.length < MIN_CAR_NUM) {
            return false;
        }
        return true;
    }
}
