package racinggame.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String carName;
    private final Distance distance;
    private static final int MOVING_MIN_COUNT = 3;

    public Car(String carName) {
        this.carName = carName;
        this.distance = new Distance();
    }

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = new Distance(distance);
    }

    public void moving(int randomNumber) {
        if (randomNumber > MOVING_MIN_COUNT) {
            this.distance.moveForward();
        }
    }

    public String displayDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.distance.getDistance(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car o) {
        return this.distance.getDistance() - o.distance.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

}
