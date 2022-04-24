package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car {
    private CarName carName;
    private Movement movement;

    public Car(String name) {
        carName = new CarName(name);
        movement = new Movement(0);
    }

    public void drive() {
        movement.executeForwardOrStop(Randoms.pickNumberInRange(0, 9));
    }

    public int getPosition() {
        return movement.getPosition();
    }

    public String getCarName() {
        return carName.getName();
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
