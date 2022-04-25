package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars of(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>(carNames.size());
        for (CarName carName : carNames) {
            cars.add(Car.of(carName));
        }
        return new RacingCars(cars);
    }

    public int getCarsCount() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public String getCarName(int index) {
        return cars.get(index).getCarName().getName();
    }

    public String getWinnerCarName() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinneers(winners, car, maxPosition);
        }
        return createWinnerCarsNameBulk(winners);
    }

    private int getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getCountByCarPosition());
        }
        return Collections.max(positions);
    }

    private void addWinneers(List<Car> maxPositionCars, Car car, int maxPosition) {
        if (car.getCountByCarPosition() == maxPosition) {
            maxPositionCars.add(car);
        }
    }

    private String createWinnerCarsNameBulk(List<Car> cars) {
        StringJoiner joiner = new StringJoiner(",");
        for (Car car : cars) {
            joiner.add(car.getCarName().getName());
        }
        return joiner.toString();
    }
}
