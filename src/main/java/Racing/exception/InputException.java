package Racing.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    public void inputValidation(List<String> list){
        for(String input : list){
            isValidName(input);
        }

        isDuplicatedName(list);
    }

    //입력받은 이름 검증.
    public void isValidName(String input){
        if(input.length() > 5){
            throw new IllegalArgumentException("[ERROR] : 이름은 5자 이하만 가능합니다.");
        }

        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 이름을 1자 이상 입력하세요.");
        }

        if(input.contains(" ")){
            throw new IllegalArgumentException("[ERROR] : 이름에 공백이 포함될 수 없습니다.");
        }
    }

    //이름에 중복이 있는지 검증.
    public void isDuplicatedName(List<String> list){
        Set<String> listToSet = new HashSet<>(list);
        if(listToSet.size()!=list.size()){
            throw new IllegalArgumentException("[ERROR] : 이름은 중복될 수 없습니다.");
        }


    }

    // 실행 횟수 검증, 숫자인지 확인한다.
    public void isNumber(String input){

        try {
            Integer.parseInt(input);
        }catch(IllegalArgumentException ie){
            throw new IllegalArgumentException("[ERROR] : 실행 횟수는 정수만 입력 가능합니다.");
        }

        if(Integer.parseInt(input)<=0){
            throw new IllegalArgumentException("[ERROR] : 실행 횟수는 양의 정수만 입력 가능합니다.");
        }
    }

}
