package racinggame.game.car;

import nextstep.utils.Randoms;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private static final int FORWARD_MOVEMENT_POINT = 4;

    private final String name;
    private int forwardMovementCount;


    public Car(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public int getForwardMovementCount() {
        return forwardMovementCount;
    }
}
