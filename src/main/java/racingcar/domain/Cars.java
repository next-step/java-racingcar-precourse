package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars release(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNames.split(",");
        for (String carName: carNameArray) {
            cars.add(Car.release(carName));
        }
        return new Cars(cars);
    }

    public void move(Coordinates coordinates) {
        for (Car car: this.cars) {
            car.move(coordinates.pop());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
