package Validator;

public class Validator {
    public void isCarNameLengthValid(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 길이 5이하 이어야 합니다.");
        }
    }

    public void hasCarNameSpace(String carName){
        if(carName.contains(" ")){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백을 포함할 수 없습니다.");
        }
    }

    public void isCarNameRangeValid(String carName){
        if(!carName.matches("[a-zA-z_0-9]")){
            throw new IllegalArgumentException("[ERROR] 자동차 이름으로 사용할 수 없는 단어가 입력되었습니다.");
        }
    }
}
