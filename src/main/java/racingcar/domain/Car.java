package racingcar.domain;

import static racingcar.constant.Constant.*;

public class Car {
    private CarName name;
    private int distance;

    public Car(CarName name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(String name) {
        return new Car(new CarName(name), INITIALIZE_NUMBER);

    }

    public CarName getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int number) {
        if (matchCarDistance(number)) {
            distance++;
        }
    }

    public boolean matchCarDistance(int distance) {
        return distance >= MOVE_MIN_VALUE;
    }
}
