package racingcar.domain;

import racingcar.common.CarMessage;
import racingcar.common.ExcMessage;

import java.util.List;

public class CarName {
    private String name;

    public CarName(){

    }

    public CarName(String name){
        isCheck(name);
        carNameCheck(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    /** 자동차 이름 길이 체크 5자 이하*/
    public void carNameCheck(String name){
        if(name.length() > CarMessage.NAME_LENGTH) throw new IllegalArgumentException(ExcMessage.ERROR_LENGTH);
    }

    /** 빈값 체크*/
    public void isCheck(String name){
        if(name.length() == 0) throw new IllegalArgumentException(ExcMessage.ERROR_EMPTY);
    }
}
