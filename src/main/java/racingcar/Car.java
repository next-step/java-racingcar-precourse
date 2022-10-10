package racingcar;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final int MOVE_POINT = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMove(number)) {
            position.moveForward();
        }
    }

    private boolean isMove(int number) {
        return number >= MOVE_POINT;
    }


    @Override
    public String toString() {
        return name.toString() + " : " + position.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car target = (Car) o;
        return name.equals(target.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car target) {
        return this.position.compareTo(target.position);
    }
}
