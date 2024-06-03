package Validator;

public class Validator {
    public void isCarNameLengthValid(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 길이 5이하 이어야 합니다.");
        }
    }


}
