package racingcar.utils;

public class ValidationUtil {
    public static void isCarNameValid(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("car name length must be less than 5");
        }
    }

    public static void isNumberInRange(int number){
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("number must be between 0 and 9");
        }
    }
}
