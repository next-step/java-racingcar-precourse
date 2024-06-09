package validation;

import enums.PrintMessage;
import enums.RegexPattern;

public class InputValidator {
    private static final String ERROR = PrintMessage.ERROR.getMessage();
    private InputValidator(){
    }

    public static void validateIsNumber(String input){
        if(!RegexPattern.REGEXP_PATTERN_NUMBER.match(input)){
            throw new IllegalArgumentException(ERROR+"숫자를 입력해주세요.");
        }
    }

    public static void validateIsNameLessThan5(String input){
        if(input.length()>5){
            throw new IllegalArgumentException(ERROR+"자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
