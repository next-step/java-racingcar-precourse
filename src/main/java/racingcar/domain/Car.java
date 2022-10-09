package racingcar.domain;

import racingcar.constant.CarStatus;

import java.util.ArrayList;

public class Car {
    private static final int MOVE_STANDARD_POINT = 4;

    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance();
    }

    public String getName() {
        return this.name.getName();
    }

    public ArrayList<Boolean> getDistances() {
        return this.distance.getDistances();
    }

    public void move(int movePoint) {
        Boolean moveResult = CarStatus.STOP;
        if (movePoint >= MOVE_STANDARD_POINT) {
            moveResult = CarStatus.MOVE;
        }

        distance.setDistance(moveResult);
    }
}
