package com.example.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars == null || cars.size() == 0) {
            throw new IllegalArgumentException("null이거나 길이가 0입니다.");
        }
        this.cars = cars;
    }

    public void go() {
        Random random = new Random();
        for (Car car : cars) {
            int randomNumber = random.nextInt(10);
            car.goOrNot(randomNumber >= 4);
        }
    }

    public String getNames() {
        StringBuilder namesStringBuilder = new StringBuilder();
        for (Car car : cars) {
            namesStringBuilder.append(car.getName().getName())
                    .append(",");
        }

        return namesStringBuilder.substring(0, namesStringBuilder.length() - 1);
    }

    public String getCurrentState() {
        StringBuilder currentStateStringBuilder = new StringBuilder();
        for (Car car : cars) {
            currentStateStringBuilder.append(car.getCurrentState())
                    .append("\n");
        }

        return currentStateStringBuilder.toString();
    }

    public Distance getMaxDistance() {
        if (cars.size() == 0) {
            throw new IllegalStateException();
        }
        Distance maxDistance = cars.get(0).getDistance();
        for (Car car : cars) {
            Distance currentCarDistance = car.getDistance();
            maxDistance = maxDistance.getDistance() >= currentCarDistance.getDistance() ? maxDistance : currentCarDistance;
        }

        return maxDistance;
    }

    public Cars findCar(Distance distance) {
        List<Car> found = new ArrayList<>();

        for (Car car : cars) {
            compareAndAdd(found, car, distance);
        }

        return new Cars(found);
    }

    private void compareAndAdd(List<Car> cars, Car car, Distance distance) {
        if (car.getDistance().getDistance() == distance.getDistance()) {
            cars.add(car);
        }
    }
}
