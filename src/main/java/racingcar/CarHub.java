package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarHub {

    private final List<Car> cars;

    public CarHub() {
        this.cars = new ArrayList<>();
    }

    public void init(String... names) {
        try {
            for (String name : names) {
                cars.add(new Car(name));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5차 이하여야합니다.");
            throw e;
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
