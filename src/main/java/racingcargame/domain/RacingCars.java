package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars makeCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        CarNames carNames = CarNames.of(carNamesInput);
        for (CarName carName : carNames
        ) {
            cars.add(Car.of(carName));
        }
        return new RacingCars(cars);
    }
}
