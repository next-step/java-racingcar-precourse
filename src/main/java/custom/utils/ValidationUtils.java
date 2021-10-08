package custom.utils;



public class ValidationUtils {

    public static boolean carValiDation(String inputStr) {

        inputStr = ValidationUtils.isEmpty(inputStr);
        if("".equals(inputStr)){
            return false;
        }
        return true;
    }

    public static String isEmpty(String inputStr){
        return String.valueOf(inputStr) == "null" ? "" : inputStr;
    }

    public static String rmAllSpace(String inputStr){
        return inputStr.replaceAll("(\r\n|\r|\n|\n\r|\\p{Z}|\\t)", "");
    }


}
