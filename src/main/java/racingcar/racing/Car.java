package racingcar.racing;

import racingcar.common.Position;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public void move(int moveNumber) {
        Forward forward = new Forward(moveNumber);

        if (forward.isAvailableForward()) {
            position.forward();
        }
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
