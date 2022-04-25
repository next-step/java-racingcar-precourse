package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarCollection {

    private final List<Car> cars;

    public CarCollection(String carNames) {
        validateInputNames(carNames);
        cars = new ArrayList<>(parseInputNames(carNames));
    }

    public void tryMoving() {
        for (Car car : cars) {
            car.tryMoving();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = Collections.max(cars).getPosition();

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addCarIfPositionEquals(maxPosition, car, winners);
        }

        return winners;
    }

    private void addCarIfPositionEquals(int position, Car car, List<Car> cars) {
        if (car.getPosition() == position) {
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateInputNames(String inputNames) {
        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private List<Car> parseInputNames(String inputNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : inputNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
