package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> findCars() {
        return cars;
    }

    public String getResults() {
        StringJoiner sj = new StringJoiner("\n");
        for (Car car : cars) {
            sj.add(car.getResult());
        }
        return sj.toString();
    }
}
