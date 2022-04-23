package racingcar.car.model.domain;

public class Location {
    private final int CAR_MOVE_CONDITION = 4;
    private int location;

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move(int input) {
        if (canMove(input))
            location = location + 1;
    }

    private boolean canMove(int input) {
        return input >= CAR_MOVE_CONDITION;
    }
}
