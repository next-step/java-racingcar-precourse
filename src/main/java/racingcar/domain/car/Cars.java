package racingcar.domain.car;

import racingcar.movestategy.MoveStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final String NAME_SPLIT_REGEX = ",";
    private final List<Car> cars;

    private Cars(String carNames, MoveStrategy moveStrategy) {
        this.cars = carsInit(carNames, moveStrategy);
    }

    private List<Car> carsInit(String carNames, MoveStrategy moveStrategy) {
        return Arrays.stream(splitCarNames(carNames))
                .map(cName -> Car.of(cName, moveStrategy))
                .collect(Collectors.toList());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(NAME_SPLIT_REGEX);
    }


    public static Cars of(String carNames, MoveStrategy moveStrategy) {
        return new Cars(carNames, moveStrategy);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.forward();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int carCount() {
        return cars.size();
    }
}
