package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_CONDITION_NUMBER = 4;

    private Name name;

    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void moveCar() {
        this.position.moveForward();
    }

    public void judgeAndMove(int number) {
        if (isMoveNumber(number)) {
            this.moveCar();
        }
    }

    private boolean isMoveNumber(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    public int compareHighPosition(int highPosition) {
        return Math.max(this.getPosition(), highPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
