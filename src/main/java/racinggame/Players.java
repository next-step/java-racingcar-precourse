package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Car> cars;

    public Players(List<Car> cars) {
        this.cars = cars;
    }

    public static Players createPlayersByCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Players(cars);
    }
}
