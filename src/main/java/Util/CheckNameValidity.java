package Util;

import java.util.regex.Pattern;

public class CheckNameValidity {

    private CheckNameValidity() {

    }

    public static boolean checkNameValidity(String name) {
        if(!checkNameLength(name)) {
            return false;
        }
        if(!checkEnglish(name)){
            return false;
        }
        if(checkBlank(name)){
            return false;
        }
        return true;
    }

    private static boolean checkNameLength(String name) {
        return name.length() <= 5;
    }

    private static boolean checkEnglish(String name) {
        return Pattern.matches("^[a-zA-z]*$",name);
    }

    private static boolean checkBlank(String name) {
        return name.contains(" ");
    }


}
