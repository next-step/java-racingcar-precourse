package racingcar.domain;

import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNumberOfCarsExecption;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        setCars(carNames);
    }

    private void setCars(String[] carNames) {
        hasMoreThanOne(carNames);
        for (String name : carNames) {
            Car car = new Car(name);
            addCar(car);
        }
    }

    private void hasMoreThanOne(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new InvalidNumberOfCarsExecption();
        }
    }

    private void addCar(Car car) {
        checkDuplicate(car);
        cars.add(car);
    }

    private void checkDuplicate(Car car) {
        if (isContains(car)) {
            throw new DuplicateNameException();
        }
    }

    private boolean isContains(Car car) {
        return cars.contains(car);
    }

    public int getSize() {
        return cars.size();
    }

}
