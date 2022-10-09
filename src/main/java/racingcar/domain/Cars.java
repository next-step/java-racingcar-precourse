package racingcar.domain;

import racingcar.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String NAME_SPLIT_SEPARATOR = ",";
    private final List<Car> cars;

    public Cars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArr = carNames.split(NAME_SPLIT_SEPARATOR, -1);
        for (String carName : carNameArr) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    public void moveCars() {
        for (int i = 0; i < this.cars.size(); i++) {
            Car car = getIndex(i);
            car.move();
        }
    }

    private Car getIndex(int index) {
        if (isEmpty()) {
            throw new IllegalStateException(ErrorMessage.ERROR_NOT_CARS);
        }
        return this.cars.get(index);
    }

    public boolean isEmpty() {
        return this.cars == null || this.cars.isEmpty();
    }

    public List<Car> getCars() {
        return cars;
    }
}
