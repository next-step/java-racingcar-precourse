package com.racingcar.domain;

public class Car implements Comparable<Car> {

    public static final Integer MOVE_POSITION_VALUE = 1;
    public static final Integer MIN_CONDITION_OF_CAR_MOVING = 0;
    public static final Integer MAX_CONDITION_OF_CAR_MOVING = 3;
    public static final String CAR_SHAPE = "-";

    private final CarPosition carPosition;
    private final CarName carName;

    private Car(CarPosition carPosition, CarName carName) {
        this.carPosition = carPosition;
        this.carName = carName;
    }

    public void moveCar() {
        carPosition.addCarPosition(MOVE_POSITION_VALUE);
    }

    public Boolean isCarMoving(MovingCondition condition) {
        return !(condition.biggerThan(MovingCondition.of(MIN_CONDITION_OF_CAR_MOVING)) &&
                condition.smallerThan(MovingCondition.of(MAX_CONDITION_OF_CAR_MOVING)));
    }

    public Boolean isSamePosition(Car car) {
        return carPosition.equals(car.carPosition);
    }

    public String makeCarPosition() {
        return carPosition.makeCarPosition(CAR_SHAPE);
    }

    public Winner winner() {
        return Winner.of(carName);
    }

    public static Car of(CarPosition carPosition, CarName carName) {
        return new Car(carPosition, carName);
    }

    @Override
    public int compareTo(Car o) {
        return this.carPosition.compareTo(o.carPosition);
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}
