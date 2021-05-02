package racing.util;

public class ValidationUtil {

    public static boolean numberChk(String str){
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }

}
