package nextstep.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String DEFAULT_SPLIT = ",";
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    List<Car> cars;

    public Cars(String names) {
        this.cars = mapCars(names);
    }

    private static List<Car> mapCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(DEFAULT_SPLIT)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<MoveResult> move() {
        List<MoveResult> results = new ArrayList<>();
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            results.add(car.move(random));
        }
        return results;
    }
}
