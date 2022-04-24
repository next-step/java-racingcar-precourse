package utils;

import java.util.*;

public class ValidationUtils {
    public static final int MIN_INPUT_LENGTH = 1;
    public static final int MAX_INPUT_LENGTH = 5;
    public static final String INVALID_INPUT_LENGTH = "[ERROR] 자동차이름은 1자리이상 5자리이하만 입력가능합니다.";
    public static final String INVALID_INPUT_DUPLICATE = "[ERROR] 중복값은 입력할 수 없습니다.";
    public static final String INVALID_INPUT_TYPE_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다.";

    public static boolean validStringLength(String input){
        return input.trim().length() >= MIN_INPUT_LENGTH && input.trim().length() <= MAX_INPUT_LENGTH;
    }
    public static void validationCarName(String input){
        if(!ValidationUtils.validStringLength(input)){
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH);
        }
    }
    public static void validationCarNameList(List<String> carNameList){
        Set<String> carsSet = new HashSet<>(carNameList);
        if(carsSet.size() != carNameList.size()){
            throw new IllegalArgumentException(INVALID_INPUT_DUPLICATE);
        }
    }
    public static void validNumberType(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE_NUMBER);
        }
    }
}
