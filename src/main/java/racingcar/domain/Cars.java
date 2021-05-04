package racingcar.domain;

import racingcar.exception.CarsException;
import racingcar.exception.NameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

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
            throw new CarsException.InvalidCountException();
        }
    }

    private void addCar(Car car) {
        checkDuplicate(car);
        cars.add(car);
    }

    private void checkDuplicate(Car car) {
        if (isContains(car)) {
            throw new NameException.DuplicateException();
        }
    }

    private boolean isContains(Car car) {
        return cars.contains(car);
    }

    public int getSize() {
        return cars.size();
    }

    public void move(MoveCondition moveCondition) {
        for (Car car : cars) {
            car.move(moveCondition.getMoveDistance());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : cars) {
            addWinner(winners, maxDistance, car);
        }
        return winners;
    }

    private void addWinner(List<Car> winners, int maxDistance, Car car) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }

    private int getMaxDistance() {
        Collections.sort(cars);
        return getFirstDistance();
    }

    private int getFirstDistance() {
        return cars.get(0).getDistance();
    }

}
