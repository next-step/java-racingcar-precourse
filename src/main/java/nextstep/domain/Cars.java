package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String DEFAULT_SPLIT = ",";

    private final List<Car> cars;
    private final Random random;

    public Cars(String names, Random random) {
        this.cars = mapCars(names);
        this.random = random;
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
            int number = random.generate();
            results.add(car.move(number));
        }
        return results;
    }

    public int maxDistance() {
        int max = 0;
        for (Car car : cars) {
            max = car.getGreaterDistance(max);
        }
        return max;
    }

    public String getWinners() {
        int maxDistance = maxDistance();
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb = car.appendName(sb, maxDistance);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
