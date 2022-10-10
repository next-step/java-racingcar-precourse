package racingcar.domain;

import racingcar.exception.RacingCarIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        createCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Car getCar(int index) {
        try {
            return cars.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new RacingCarIllegalArgumentException("조회 할 자동차가 존재하지 않습니다. " + e.getMessage());
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int getRaceCarCount() {
        return cars.size();
    }

    private void createCars(String[] carNames) {
        cars = new ArrayList<>();

        for (String name : carNames) {
            addCar(new Car(name));
        }
    }
}
