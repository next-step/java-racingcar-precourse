
package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = generateToCars(cars);
    }

    private List<Car> generateToCars(List<String> cars) {
        return cars.stream()
                .map(carName -> new Car(new CarName(carName)))
                .collect(Collectors.toList());
    }

    public int size() {
        return cars.size();
    }

    public Car get(int i) {
        return cars.get(i);
    }
}
