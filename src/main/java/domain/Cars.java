
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

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> selectWinners() {
        int maxMoved = getMaxMoved();
        return cars.stream()
                .filter(car -> car.moved() == maxMoved)
                .map(Car::carName)
                .collect(Collectors.toList());
    }

    private int getMaxMoved() {
        return cars.stream()
                .mapToInt(Car::moved)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public int size() {
        return cars.size();
    }

    public Car get(int i) {
        return cars.get(i);
    }
}