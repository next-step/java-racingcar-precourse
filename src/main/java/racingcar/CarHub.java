package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarHub {

    private final List<Car> cars;

    public CarHub(String... names) throws IllegalArgumentException {
        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void goCars() {
        int moveDistance = RandomUtils.getRandomNumberForMove();

        for (Car car : cars) {
            car.go(moveDistance);
        }
    }
}
