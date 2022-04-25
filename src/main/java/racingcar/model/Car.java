package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final MovingRule movingRule = new MovingRule();

    private CarName carName;
    private Distance distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.distance = new Distance();
    }

    public void race() {
        int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        MovingStatus movingStatus = movingRule.behave(randomNum);
        if (movingStatus.isGoing()) {
            this.move();
        }
    }

    public void move() {
        distance.increase();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public String getName() {
        return this.carName.getName();
    }
}
