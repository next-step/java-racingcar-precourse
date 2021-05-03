package racingcar;

public class ValidationUtils {
    public static boolean validName(String carName) {
        if(carName.length() > 5){
            return false;
        }
        return true;
    }
}
