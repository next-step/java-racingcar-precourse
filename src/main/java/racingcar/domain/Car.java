package racingcar.domain;

import java.util.List;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(final String name) {
        this(new CarName(name));
    }

    public Car(final CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public void moveForward() {
        this.position.moveForward();
    }

    public String getName() {
        return carName.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public void move(Condition condition) {
        if (condition.isMovableCondition()) {
            moveForward();
        }
    }

    public void checkPositionForWinners(Position maxPosition, List<Car> winners) {
        if (position.equals(maxPosition)) {
            winners.add(this);
        }
    }
}
