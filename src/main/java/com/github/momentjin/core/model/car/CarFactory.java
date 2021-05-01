package com.github.momentjin.core.model.car;

import com.github.momentjin.core.model.ConditionalMovableObject;

public class CarFactory {

    public static ConditionalMovableObject create(String carName) {

        OneLengthNumberGenerator numberGenerator = new OneLengthNumberGenerator();
        CarMoveCondition carMoveCondition = new CarMoveCondition(numberGenerator);
        Car car = new Car(carName);

        return new ConditionalMovableObject(car, carMoveCondition);
    }
}
