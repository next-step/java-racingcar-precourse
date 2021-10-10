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

    public void goAndStop(int randomNum) {
        if(randomNum >= 4) {
            this.distance += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceStr() {
        StringBuilder distanceStr = new StringBuilder();
        for(int i=0; i<this.distance; i++) {
            distanceStr.append("-");
        }
        return distanceStr.toString();
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
