package racingcar.domain;

import racingcar.util.RandomUtils;

public class Car implements Comparable<Car> {
    private static final int MAX_STOP_NUMBER = 3; //3 이하일 경우 정지.
    private static final int MOVE_FORWARD_DISTANCE = 1; //1회 전진 시 이동하는 position

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber > MAX_STOP_NUMBER) {
            moveForward();
        }
    }

    void moveForward() {
        carPosition.setPosition(carPosition.getPosition() + MOVE_FORWARD_DISTANCE);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(getPosition(), car.getPosition());
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

        if (!carName.equals(car.carName)) {
            return false;
        }
        return carPosition.equals(car.carPosition);
    }

    @Override
    public int hashCode() {
        int result = carName.hashCode();
        result = 31 * result + carPosition.hashCode();
        return result;
    }
}
