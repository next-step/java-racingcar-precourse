package utils;

public class ValidationUtil {
    
    public static final int NAME_MAX_LENGTH = 5;
    
    public static boolean validCarNameLength(String carName) {
        return carName.length() <= NAME_MAX_LENGTH;
    }
    
}
