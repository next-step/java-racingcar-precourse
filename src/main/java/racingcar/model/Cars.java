package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> depart() {
        for (Car car : cars) {
            car.depart();
        }
        return this.cars;
    }

    public List<Car> geMaxForwardCars() {
        int maxForwardCount = getMaxForwardCount();

        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (maxForwardCount == car.getForwardCount()) winners.add(car);
        }
        return winners;
    }

    private int getMaxForwardCount() {
        int maxForwardCount = 0;
        for (Car car : cars) {
            maxForwardCount = Math.max(maxForwardCount, car.getForwardCount());
        }
        return maxForwardCount;
    }
}
