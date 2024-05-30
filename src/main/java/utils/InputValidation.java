package utils;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    public static void isLowerFive(String[] cars){
        for(String car:cars){
            if(car.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 가능합니다.");
            }
        }

    }
    public static void isContainBlank(String[] cars){
        for(String car: cars){
            if(car.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
        }

    }
    public static void isDuplicate(String[] cars){
        List<String> tmplist = new ArrayList<>();
        for(String car : cars){
            if(!tmplist.contains(car)){
                tmplist.add(car);
            }
            else{
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }

    }
    public static void isNumber(String input){
        for(int i =0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("시도 회수는 정수를 입력하세요.");
            }
        }

    }
    public static void isValidInput(String[] cars){
        isLowerFive(cars);
        isContainBlank(cars);
        isDuplicate(cars);

    }

}
