package racingcar.domain;

public class Car {
    private static final int DEFAULT_MOVE_DISTANCE = 0;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int FORWARD_DISTANCE_NUMBER = 1;

    private String name;
    private int moveDistance;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.moveDistance = DEFAULT_MOVE_DISTANCE;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void moveForward(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            addMoveDistance();
        }
    }

    private void addMoveDistance() {
        this.moveDistance += FORWARD_DISTANCE_NUMBER;
    }
}
