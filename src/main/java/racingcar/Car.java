package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition();
    }

    public String getName() {
        return this.carName.getName();
    }

    public void moveForward() {
        this.carPosition.move();
    }

    public int getCurrentPosition() {
        return this.carPosition.getPosition();
    }

    public void carBehavior(int number) {
        if(isMove(number))
            moveForward();
    }

    public boolean isMove(int number) {
        return number >= 4 && number <= 9;
    }

    public boolean isStart() {
        return this.carPosition.isStart();
    }

    public String displayTrace() {
        return this.carPosition.getTrace();
    }


}
