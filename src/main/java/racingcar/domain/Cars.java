package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.common.PrintMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = mappingToCar(names);
    }

    private static List<Car> mappingToCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void move(MovingStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> findWinnerCars() {
        Car winner = findMaxPositionCar();
        return findSamePositionCars(winner);
    }

    private Car findMaxPositionCar() {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = car.isBiggerThan(winner) ? car : winner;
        }
        return winner;
    }

    private List<Car> findSamePositionCars(Car winner) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinners(winner, winners, car);
        }
        return winners;
    }

    private void addWinners(Car winner, List<Car> winners, Car car) {
        if (car.isSamePosition(winner)) {
            winners.add(car);
        }
    }

    public void printCarsPosition() {
        for (Car car : cars) {
            PrintMessage.print(car.createCarPositionMessage());
        }
        PrintMessage.printLine();
    }
}
