package racingcar;

public class ValidationUtils {
    public static boolean validateNumber(int no) {
        if(no >= 0 && no <= 9) {
            return true;
        }
        return false;
    }
}
