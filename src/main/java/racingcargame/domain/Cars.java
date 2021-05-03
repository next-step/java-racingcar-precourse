package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        CarNames carNames = CarNames.of(carNamesInput);
        for (CarName carName : carNames) {
            cars.add(Car.of(carName));
        }
        return new Cars(cars);
    }

    public void randomMove() {
        for (Car car : cars) {
            car.randomMove();
        }
    }

    public String getResultString() {
        StringBuilder resultString = new StringBuilder();
        for (Car car : cars) {
            resultString.append(car.getResultString());
        }
        return resultString.toString();
    }
}
