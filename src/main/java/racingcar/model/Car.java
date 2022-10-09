package racingcar.model;

import racingcar.enumeration.CarStatus;

public class Car {
    public static final int FORWARD_START_INCLUSIVE = 4;
    public static final int FORWARD_END_INCLUSIVE = 9;
    private final Name name;
    private final ForwardCount forwardCount;
    private final ForwardString forwardString;

    public Car(Name name, ForwardCount forwardCount, ForwardString forwardString) {
        this.name = name;
        this.forwardCount = forwardCount;
        this.forwardString = forwardString;
    }

    public void setForwardResultByRandomNum(RandomNum randomNum) {
        if (randomNum.getNum() >= FORWARD_START_INCLUSIVE && randomNum.getNum() <= FORWARD_END_INCLUSIVE) {
            forwardCount.setCountByCarStatus(CarStatus.FORWARD);
            forwardString.setStringByCarStatus(CarStatus.FORWARD);
            return;
        }
        forwardCount.setCountByCarStatus(CarStatus.STOP);
        forwardString.setStringByCarStatus(CarStatus.STOP);
    }

    public Name getName() {
        return name;
    }

    public ForwardCount getForwardCount() {
        return forwardCount;
    }

    public ForwardString getForwardString() {
        return forwardString;
    }
}
