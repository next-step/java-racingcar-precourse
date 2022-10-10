package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Car> cars;

    RacingCar(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        RacingUtils.validationCarNames(carNames);
        cars = map(carNames);
    }

    List<Car> getCars() {
        return cars;
    }

    private List<Car> map(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }

        return cars;
    }

    void racing() {
        for (Car car : cars) {
            car.tryMove();
            CarUtils.displayCarNameAndPath(car);
        }
        System.out.println();
    }

}
