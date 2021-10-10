package racinggame.domain;

import java.util.Objects;

public class Car {
    private String carName;
    private int distance;

    public Car(String carName) {
        carNameValidation(carName);
        this.carName = carName;
        this.distance = 0;
    }

    public void carNameValidation(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException();
        }
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
