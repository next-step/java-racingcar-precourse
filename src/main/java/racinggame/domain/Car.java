package racinggame.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Distance distance;

    public Car(final CarName carName) {
        this.carName = carName;
        this.distance = new Distance(0);
    }

    public void goAndStop(int randomNum) {
        if(randomNum >= 4) {
            distance.forwardDistance();
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getDistanceStr() {
        StringBuilder distanceStr = new StringBuilder();
        for(int i=0; i<this.distance.getDistance(); i++) {
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
