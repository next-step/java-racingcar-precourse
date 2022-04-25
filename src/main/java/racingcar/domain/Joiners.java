package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 10:28 오후
 */
public class Joiners {
    List<Car> cars;

    private Joiners(List<Car> cars) {
        this.cars = cars;
    }

    public static Joiners of(Player player) {
        List<String> carNames = player.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Joiners(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }
}
