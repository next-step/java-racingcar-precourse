package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.ValidationUtil;

public class CarList {
    private static final String NAME_DELIMITER = ",";
    private static final int FIRST_INDEX_NUMBER = 0;

    private List<Car> cars;

    public CarList() {
        init();
    }

    public CarList(String carNames) {
        init();
        validateCars(carNames);
        for (String carName : carNames.split(NAME_DELIMITER)) {
            cars.add(new Car(carName.trim()));
        }
    }

    public void init() {
        cars = new ArrayList<>();
    }

    public int size() {
        return cars.size();
    }

    public void race(int lap) {
        for (int i = 0; i < lap; i++) {
            raceOneLap();
        }
    }

    public void raceOneLap() {
        for (Car car : cars) {
            car.goForwardAndPrint();
        }
        System.out.println();
    }

    public boolean isNotEmpty() {
        return !cars.isEmpty();
    }

    public List<Car> getTopRankers() {
        List<Car> topRankers = new ArrayList<>();

        for (Car car : cars) {
            compareAndAppend(topRankers, car);
        }

        return topRankers;
    }

    private void compareAndAppend(List<Car> topRankers, Car car) {
        if (topRankers.isEmpty() || topRankers.get(FIRST_INDEX_NUMBER).getDistance() == car.getDistance()) {
            topRankers.add(car);
        }

        if (topRankers.get(FIRST_INDEX_NUMBER).getDistance() < car.getDistance()) {
            topRankers.clear();
            topRankers.add(car);
        }
    }

    private void validateCars(String carNames) {
        ValidationUtil.validateNull(carNames);
    }
}
