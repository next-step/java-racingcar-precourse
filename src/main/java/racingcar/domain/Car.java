package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int MOVEMENT_STANDARD = 4;

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(DEFAULT_POSITION);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move() {
        if (isMovable()) {
            position.addPosition(MOVE_DISTANCE);
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE) >= MOVEMENT_STANDARD;
    }
}
