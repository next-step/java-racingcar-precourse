package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validationSize(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validationSize(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차 경주를 위한 최소 2대의 자동차가 필요합니다.");
        }
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }
}
