package racingcar.domain;

import racingcar.constant.CarConstant;

public class Car {
    private final CarName carName;
    private int distance;

    public Car(CarName carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public static Car createCar(String name) {
        return new Car(new CarName(name), CarConstant.CAR_DISTANCE_INIT_VALUE);
    }

    public void move(int number) {
        if (matchMove(number)) {
            increaseDistance();
        }
    }

    public boolean matchMove(int distance) {
        return distance >= CarConstant.MOVE_MINIMUM_VALUE;
    }

    private void increaseDistance() {
        this.distance++;
    }
}
