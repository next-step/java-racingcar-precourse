package racinggame;

public class ValidationUtils {
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 0;

    public static boolean validName(String name) {
        if(name.length() <= 5) {
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
        return true;
    }

    public static boolean validRandomValue(int val) {
        if(val >= MIN_NUM && val <= MAX_NUM) {
            return true;
        }
        return false;
    }
}
