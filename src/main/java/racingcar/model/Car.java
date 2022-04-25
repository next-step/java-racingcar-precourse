package racingcar.model;

public class Car {
    private final Name name;
    private final Position position;
    private static final String POSITION_TO_DASH = "-";
    private static final int MOVING_FORWARD = 4;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String position() {
        StringBuilder newPosition = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            newPosition.append(POSITION_TO_DASH);
        }
        return newPosition.toString();
    }

    public String name() {
        return name.getName();
    }

    public void move(MovementCondition move) {
        if (move.moving() >= MOVING_FORWARD) {
            position.move();
        }
    }

    public boolean isMaxDistance(int maxDistance) {
        return position().length() == maxDistance;
    }
}
