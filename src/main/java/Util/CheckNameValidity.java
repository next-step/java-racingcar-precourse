package Util;

import java.util.HashMap;
import java.util.regex.Pattern;

public class CheckNameValidity {
    private static HashMap<String, Boolean> sameNameHashMap = new HashMap<>();
    private CheckNameValidity() {

    }

    public static boolean checkNameValidity(String name) {
        if(checkNameLength(name)) {// 길이가 6이상
            return false;
        }
        if(!checkOnlyEnglish(name)){// 영어가 아닌 문자 포함
            return false;
        }
        if(checkBlank(name)){ // 공백 포함
            return false;
        }
        if(checkSameName(name)){
            return false;
        }
        return true;
    }
    //5자리를 넘는지 검사
    private static boolean checkNameLength(String name) {
        return name.length() > 5;
    }
    //영어만 포함하는지 검사 (영어만있으면 T / 다른거 포함 F)
    private static boolean checkOnlyEnglish(String name) {
        return Pattern.matches("^[a-zA-z]*$",name);
    }
    //공백을 포함하면 true 아니면 false
    private static boolean checkBlank(String name) {
        return name.contains(" ");
    }
    //중복이면 true 아니면 false
    private static boolean checkSameName(String name){
        if(sameNameHashMap.containsKey(name)){
            sameNameHashMap = new HashMap<>();//중복일때 초기화하지 않으면 다음 입력시에도 영향을 줄수 있어 초기화
            return true;
        }
        sameNameHashMap.put(name,true);
        return false;
    }


}
