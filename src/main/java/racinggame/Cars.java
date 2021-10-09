package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private MoveStrategy moveStrategy;
    private final String NAME_SPLIT_REGEX = ",";

    private Cars(String carNames, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        carsInit(carNames.split(NAME_SPLIT_REGEX));
    }

    private void carsInit(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(carName -> Car.of(carName, moveStrategy))
                .collect(Collectors.toList());
    }


    public static Cars of(String carNames, MoveStrategy moveStrategy) {
        return new Cars(carNames, moveStrategy);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int carCount() {
        return cars.size();
    }
}
