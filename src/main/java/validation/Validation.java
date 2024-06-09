package validation;

import java.util.Arrays;

public class Validation {
    public void exceedNameLengthException(String carNames){
        String[] inputList = carNames.split(",");

        for( String name : inputList){
            // 1. 이름이 "" 일 경우
            if( name.trim() == ""){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상으로 설정해주세요.");
            }
        }
    }
    public void nullNameException(String carNames){
        String[] inputList = carNames.split(",");

        for( String name : inputList) {
            // 2. 이름이 5글자 보다 클 경우
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 설정해주세요.");
            }
        }
    }
    public void duplicateNameException(String carNames){
        String[] inputList = carNames.split(",");

        if( (Arrays.stream(inputList).map(String::trim).distinct().count()) != inputList.length){
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됩니다.");
        }
    }
    public void emptyException(String carNames){
        if (carNames.equals("")){
            throw new IllegalArgumentException("[ERROR] 참가자는 1명 이상으로 설정해주세요.");
        }
    }
    public boolean inputNameCheck(String carNames){
        String[] inputList = carNames.split(",");

        try{
            emptyException(carNames);
            exceedNameLengthException(carNames);
            nullNameException(carNames);
            duplicateNameException(carNames);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void integerRangeException(String count){
        if(Integer.parseInt(count) <= 0){
            throw new IllegalArgumentException("[ERROR] 1이상 정수를 입력해주세요.");
        }
    }

    public void notIntegerException(String count){
        try{
            Integer.parseInt(count);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }
    public boolean inputCountCheck(String count){
        try{
            notIntegerException(count);
            integerRangeException(count);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
