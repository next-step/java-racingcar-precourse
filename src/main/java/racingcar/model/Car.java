package racingcar.model;

import Utils.CarName;
import enums.MovingStatus;

public class Car {
    private final int START_LINE = 0;

    private int distance;
    private CarName carName;


    public Car(String carName) {
        this.distance = START_LINE;
        this.carName = new CarName(carName);
    }

    public int moveCar(MovingStatus status){
        if(status.isMovingForward()) {
            this.distance++;
        }
        return this.distance;
    }

    public boolean isWinner(int maxDistance) {
        return this.distance == maxDistance;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public int getDistance() {
        return this.distance;
    }
}
