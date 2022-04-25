package racingcar.domain;

import racingcar.constant.ConstantNumber;

public class Car {

    private CarPosition position;
    private CarName name;

    public Car(final String name, CarPosition position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move(int number) {
        if (number >= ConstantNumber.MOVABLE_NUMBER) {
            position = position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public CarName getName() {
        return name;
    }

    public boolean isWinner(int maxPostition) {
        return position.isEqual(maxPostition);
    }
}
