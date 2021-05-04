package domain;

import java.util.Objects;

public class Car {

    private int distance;
    private Name carName;
    private static final int MOVABLE_NUMBER = 4;

    public Car(String carName) {
        this(new Name(carName));
    }

    public Car(Name carName) {
        this(0, carName);
    }

    public Car(int distance, String carName) {
        this(distance, new Name(carName));
    }

    public Car(int distance, Name carName) {
        this.distance = distance;
        this.carName = carName;
    }

    public int distance() {
        return this.distance;
    }

    public String carName() {
        return this.carName.name();
    }

    public void move() {
        checkOverflowNumber(this.distance);
        this.distance++;
    }

    public boolean isMovable(int number) {
        return number > MOVABLE_NUMBER;
    }

    private void checkOverflowNumber(int distance) {
        if (distance == Integer.MAX_VALUE) {
            throw new ArithmeticException("자동차가 움직일수 있는 범위를 넘었습니다.(Integer 범위를 넘었습니다.)");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName.name() + ": ");

        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
