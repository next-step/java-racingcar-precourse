package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.config.Configuration;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(Configuration.CAR_NAME_DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move();
        }

        return cars;
    }

    public List<Car> getHeadCars() {
        int maxDistance = getMaxDistance();

        List<Car> headCars = new ArrayList<>();
        for (Car car : cars) {
            addMaxDistanceCar(headCars, car, maxDistance);
        }

        return headCars;
    }

    private void addMaxDistanceCar(List<Car> headCars, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            headCars.add(car);
        }
    }

    private int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
