package domain;

import java.util.List;

public class Checker {
    public void carNameRangeCheck(List<String> names) {  //잘못 입력시 다시 시작해야하므로 StringCar네임 하나 만들것
        for (String name :names) {
            int length = name.length();
            if(length>5||length<1){
                throw new IllegalArgumentException("이름의 길이를 잘못 입력");
            }
        }
    }
}
