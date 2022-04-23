package racingcar.nextstep.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void racing() {
        cars.iterator().forEachRemaining(Car::racing);
    }

    public List<String> getCarNameList() {
        List<String> list = new ArrayList<>();

        for (Car car : cars) {
            list.add(car.getCarName().getValue());
        }

        return list;
    }
}
