package racingcar.domain;

import racingcar.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_SEPARATOR = ",";
    private static final String LINE_BREAK = "\n";

    private final List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames.split(CAR_SEPARATOR)) {
            cars.add(Car.createRandomEngineCar(carName.trim()));
        }
    }

    public void drive() {
        validCarsIsNotEmpty();
        cars.forEach(Car::drive);
    }

    public List<String> getFirstPlaceCarNameList() {
        validCarsIsNotEmpty();
        int max = getMaxDistanceDriven();
        List<String> firstPlaceCarNames = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getDistanceDriven() == max) {
                firstPlaceCarNames.add(car.getCarName());
            }
        });
        return firstPlaceCarNames;
    }

    public int getMaxDistanceDriven() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getDistanceDriven()) {
                max = car.getDistanceDriven();
            }
        }
        return max;
    }

    @Override
    public String toString() {
        validCarsIsNotEmpty();
        List<String> result = new ArrayList<>();
        cars.forEach(car -> result.add(car.toString()));
        return String.join(LINE_BREAK, result);
    }

    public int size() {
        validCarsIsNotEmpty();
        return cars.size();
    }

    private void validCarsIsNotEmpty() {
        if (!ValidationUtils.isEmpty(cars)) {
            throw new IllegalStateException();
        }
    }
}
