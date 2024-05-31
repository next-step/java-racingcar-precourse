package Util;

import java.util.regex.Pattern;

public class CheckNameValidity {

    private CheckNameValidity() {

    }

    public static boolean checkNameValidity(String name) {
        if(checkNameLength(name)) {// 길이가 6이상
            return false;
        }
        if(!checkEnglish(name)){// 영어가 아닌 문자 포함
            return false;
        }
        if(checkBlank(name)){ // 공백 포함
            return false;
        }
        return true;
    }
    //5자리 이하인지 검사
    private static boolean checkNameLength(String name) {
        return name.length() > 5;
    }
    //영어만 포함하는지 검사
    private static boolean checkEnglish(String name) {
        return Pattern.matches("^[a-zA-z]*$",name);
    }
    //공백을 포함하면 true 아니면 false
    private static boolean checkBlank(String name) {
        return name.contains(" ");
    }


}
