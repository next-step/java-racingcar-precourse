package racingcar.domain;

import racingcar.utils.GenerateRandomNumUtils;
import racingcar.utils.ValidNumberConditionEnum;

public class CarInfo {
    private String name;
    private int forwardCount;

    public CarInfo(String carName){
        this.name = carName;
        this.forwardCount = ValidNumberConditionEnum.MIN_VALUE.getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public void moveForward(){
        if (isForward()) {
            moveCurrentPoint(this.getForwardCount()+1);
        }
    }

    public void moveCurrentPoint(int point) {
        this.setForwardCount(point);
    }

    private boolean isForward() {
        return generateRandomForwardNum() >= ValidNumberConditionEnum.MOVING_FORWARD.getValue();
    }

    private int generateRandomForwardNum() {
        return new GenerateRandomNumUtils().generateRandomNum();
    }

}
