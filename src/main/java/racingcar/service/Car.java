package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVEMENT_START = 0;
    private static final int MOVEMENT_END = 9;
    private static final int MOVABLE_LIMIT = 4;

    private final CarName name;
    private final CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(MOVEMENT_START, MOVEMENT_END);
        if (randomValue >= MOVABLE_LIMIT) {
            this.distance.addDistance();
        }
    }

    public String getDistance() {
        return this.distance.getDistance();
    }

    public int getDistanceSize() {
        return this.distance.getDistanceSize();
    }

    public String getName() {
        return this.name.getName();
    }
}
