package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {
    private final int RANDOM_MIN_RANGE = 0;
    private final int RANDOM_MAX_RANGE = 9;
    private final int MOVE_CONDITION = 4;

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void tryRace() {
        if (isMove(Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE))) {
            position.move();
        }
    }

    private boolean isMove(int value) {
        return value >= MOVE_CONDITION;
    }
}
