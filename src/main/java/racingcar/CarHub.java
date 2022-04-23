package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarHub {

    private final List<Car> cars;

    private static final String NAME_SEPARATOR = ",";

    public CarHub(final String names) throws IllegalArgumentException {
        if (names == null || names.equals("")) {
            throw new IllegalArgumentException("[ERROR] 자동자 이름을 입력해주세요");
        }

        this.cars = new ArrayList<>();
        for (String name : names.split(NAME_SEPARATOR)) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void goCars() {
        for (Car car : cars) {
            final int moveDistance = RandomUtils.getRandomNumberForMove();
            car.go(moveDistance);
        }
    }
}
