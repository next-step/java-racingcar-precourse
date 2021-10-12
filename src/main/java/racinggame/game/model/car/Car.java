package racinggame.game.model.car;

import nextstep.utils.Randoms;

public class Car implements Comparable<Car> {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private static final int FORWARD_MOVEMENT_POINT = 4;

    private final CarName carName;
    private int forwardMovementCount;


    public Car(CarName carName) {
        this.carName = carName;
    }


    public void runRace() {
        if(moveForward()) {
            this.forwardMovementCount ++;
        }
    }

    private boolean moveForward() {
        int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return number >= FORWARD_MOVEMENT_POINT;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getForwardMovementCount() {
        return forwardMovementCount;
    }

    @Override
    public int compareTo(Car car) {
        if(this.forwardMovementCount > car.forwardMovementCount) {
            return 1;
        }
        else if(this.forwardMovementCount == car.forwardMovementCount) {
            return 0;
        }
        return -1;
    }
}
