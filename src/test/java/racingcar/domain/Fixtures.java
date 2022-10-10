package racingcar.domain;

import racingcar.domain.car.Car;

public class Fixtures {

    public static Car car1() {
        return Car.createCar("1");
    }

    public static Car car2() {
        return Car.createCar("2");
    }
}
