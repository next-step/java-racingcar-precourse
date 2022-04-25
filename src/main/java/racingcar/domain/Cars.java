package racingcar.domain;

import racingcar.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 입력 받은 경주 할 자동차 목록
 *
 * @author suji
 * @date 2022-04-23
 **/
public class Cars {

    private static final String NAME_SPLIT_SEPARATOR = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars newInstance(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArr = carNames.split(NAME_SPLIT_SEPARATOR);
        for (String carName : carNameArr) {
            cars.add(Car.newInstance(carName));
        }
        return new Cars(cars);
    }

    public void moveCars(MoveNumbers moveNumbers) {
        for (int i = 0; i < this.cars.size(); i++) {
            Car car = getIndex(i);
            car.move(moveNumbers.getIndex(i));
        }
    }

    public Car getIndex(int index) {
        if (isEmpty()) {
            throw new IllegalStateException(ErrorMessage.ERROR_NOT_CARS);
        }
        return this.cars.get(index);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.cars.size();
    }

    public boolean isEmpty() {
        return this.cars == null || this.cars.isEmpty();
    }

    public List<Car> getCars() {
        return cars;
    }
}
