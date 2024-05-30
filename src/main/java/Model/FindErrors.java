package Model;

import java.util.*;

public class FindErrors {
    public void validCarNames(String input){
        String[] carNames = input.split(",");
        Set<String> uniqueNames = new HashSet<>();
        for(String name : carNames){
            if(name.length() > 5 ){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
            if(name.contains(" ")){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름에 띄어쓰기가 있으면 안됩니다.");
            }
            if(!uniqueNames.add(name)){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름에 중복이 있으면 안됩니다.");
            }
        }
    }

}
