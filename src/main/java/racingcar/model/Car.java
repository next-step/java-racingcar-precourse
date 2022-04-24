package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.ValidationUtil;

public class Car {
    private String name;
    private Integer steps;

    public Car(String name) {
        this.name = name;
        this.steps = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSteps() {
        return steps;
    }


    public void createSteps(int number){
        ValidationUtil.isNumberInRange(number);
        if(!isStop(number)){
            this.steps++;
        }
    }

    private Boolean isStop(int number){
        if(number >= 4){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
