package racinggame.utils;

public class ValidationUtils {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static boolean isNumberic(String str){
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validateCarName(String str){
        if(str.length() > MAX_CAR_NAME_LENGTH){
            return false;
        }
        return true;
    }
}
