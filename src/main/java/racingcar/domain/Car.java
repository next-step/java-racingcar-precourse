package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int CAR_MOVE_UNDER_LIMIT = 4;

    private CarName carName;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(int number) {
        if (number >= CAR_MOVE_UNDER_LIMIT) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return carName.getValue();
    }

    public boolean isWinnerCar(Position maxPosition) {
        if (position.equals(maxPosition)) {
            return true;
        }
        return false;
    }

    public Position getMaxPosition(Position position) {
        return this.position.findBiggerPosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position,
            car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
