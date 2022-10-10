package racingcar.referee.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final String DUPLICATE_CARS_NAME_ERROR_MESSAGE = "[ERROR] 같은 이름의 자동차를 추가할 수 없습니다.";
    public static final int RANDOM_MINIMUM_NUMBER = 0;
    public static final int RANDOM_MAXIMUM_NUMBER = 9;

    List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        validate(car);
        this.cars.add(car);
    }

    private void validate(Car addCar) {
        for (Car car : this.cars) {
            validateDuplicateCarName(addCar, car);
        }
    }

    private static void validateDuplicateCarName(Car addCar, Car car) {
        if (addCar.carName().equals(car.carName())) {
            System.out.println(DUPLICATE_CARS_NAME_ERROR_MESSAGE);
            System.out.println();
            throw new IllegalArgumentException(DUPLICATE_CARS_NAME_ERROR_MESSAGE);
        }
    }

    public int size() {
        return this.cars.size();
    }

    public List<Car> cars() {
        return this.cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(RANDOM_MINIMUM_NUMBER, RANDOM_MAXIMUM_NUMBER));
        }
    }
}
