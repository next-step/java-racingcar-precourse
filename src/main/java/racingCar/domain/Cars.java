package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = makeCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i], 0));
        }
        return carList;
    }

    public List<TryResult> move() {
        List<TryResult> tryResults = new ArrayList<>();
        for (Car car : cars) {
            tryResults.add(car.move(new RandomMovable()));
        }
        return tryResults;
    }

    public List<Car> determineWinners() {
        int max = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public String getWinnerNames() {
        return cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
    }

}
