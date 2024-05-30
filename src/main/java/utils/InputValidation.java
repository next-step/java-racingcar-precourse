package utils;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    public static void isLowerFive(String car){
        if(car.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 가능합니다.");
        }
    }
    public static void isContainBlank(String car){
        if(car.isBlank()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
        }
    }
    public static void isDuplicate(String[] cars){
        List<String> tmplist = new ArrayList<>();
        for(String car : cars){
            if(!tmplist.contains(car)){
                tmplist.add(car);
            }
            else{
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
            }
        }

    }

}
