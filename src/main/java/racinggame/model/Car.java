package racinggame.model;

import racinggame.exception.ValidationException;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String carName;
    private int distance;
    private static final int MOVING_MIN_COUNT = 3;
    private static final int DISTANCE = 1;

    private RandomNumber randomNumber;

    public Car(String carName) {
        if (!validateName(carName)) {
            throw new ValidationException();
        }
        this.carName = carName;
        this.distance = 0;
        this.randomNumber = new RandomNumber();
    }

    private boolean validateName(String carName) {
        return carName.matches("^[\\w]{1,5}$");
    }

    public void moving() {
        randomNumber.playRound();
        if (randomNumber.getRandomNumber() > MOVING_MIN_COUNT) {
            this.distance += DISTANCE;
        }
    }

    public String displayDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName) && Objects.equals(randomNumber, car.randomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance, randomNumber);
    }
}
