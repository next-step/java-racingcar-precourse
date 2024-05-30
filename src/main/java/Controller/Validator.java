package Controller;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    public void InputValidator(String names){
        for(String name : names.split(",")){
            if(name.equals("")||name.contains(" "))
                throw new IllegalArgumentException("자동차 이름에 공백은 포함될 수 없습니다.");
            if(name.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을수 없습니다.");
        }
    }

    public void InputCountMissMatchValidator(String count){
        try{
            Integer.parseInt(count);
        }catch (Exception e){
           throw new IllegalStateException("정수 외의 입력은 불가합니다.");
        }
    }
    public void InputCountValidator(int count){
        if(count < 0)
            throw new IllegalStateException("음수는 입력이 불가합니다.");

    }
    public void DuplicationValidator(String names){
        HashSet<String> set = new HashSet<>(Arrays.asList(names.split(",")));
        if(set.size() != names.split(",").length)
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
    }
}
