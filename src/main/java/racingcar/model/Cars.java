package racingcar.model;

import racingcar.model.movingStrategy.RandomMove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final String DUPLICATED_CAR_NAME_ERROR_MESSAGE = "차 이름이 중복되었습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        HashSet<Car> carSet = new HashSet<>(cars);
        if (carSet.size() < cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new RandomMove());
        }
    }

    public Cars findWinnerCars() {
        return new Cars(WinnerCars.findWinnerCars(cars));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\r\n");
        }
        return sb.toString();
    }

    public List<String> getCarNames() {
        List<String> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars.add(car.getName());
        }
        return cars;
    }
}
