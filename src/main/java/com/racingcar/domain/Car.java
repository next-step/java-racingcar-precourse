package com.racingcar.domain;

public class Car {

    public static final Integer MIN_CONDITION_OF_CAR_MOVING = 0;
    public static final Integer MAX_CONDITION_OF_CAR_MOVING = 3;

    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public Boolean isCarMoving(Integer condition) {
        return condition >= MIN_CONDITION_OF_CAR_MOVING && condition <= MAX_CONDITION_OF_CAR_MOVING ?
                Boolean.FALSE :
                Boolean.TRUE;
    }
}
