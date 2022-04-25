package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 1건 이상 입력되어야 합니다.");
        }
    }

    public Cars getFarthestTraveledCars() {
        List<Car> sorted = new ArrayList<>(cars);
        sorted.sort(Comparator.comparingInt(car -> car.getTravelDistance().toInt()));
        Collections.reverse(sorted);

        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            addToListIfTraveledDistanceEquals(result, car, sorted.get(0).getTravelDistance());
        }

        return new Cars(result);
    }

    private void addToListIfTraveledDistanceEquals(final List<Car> list, final Car car, final Distance travelDistance) {
        if (car.getTravelDistance().equals(travelDistance)) {
            list.add(car);
        }
    }

    public int count() {
        return cars.size();
    }

    public Car get(final int index) {
        return cars.get(index);
    }

    public List<Car> asList() {
        return cars;
    }
}
