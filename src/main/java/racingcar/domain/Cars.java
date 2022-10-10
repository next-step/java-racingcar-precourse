package racingcar.domain;

import racingcar.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private static void validateCars(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException("자동차는 2대 이상 입력해주세요.");
        }
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public List<Car> play() {
        for (Car car : cars) {
            car.move(Utils.generateRandomNumber());
        }
        return cars;
    }

    public List<Car> getWinners() {
        return makeWinnerList(getWinner());
    }

    private List<Car> makeWinnerList(Car winner) {
        List<Car> winners = new ArrayList<>();
        for (Car racer : cars) {
            addWinner(winner, racer, winners);
        }
        return winners;
    }

    private static void addWinner(Car winner, Car car, List<Car> winners) {
        if (car.compareWinner(winner)) {
            winners.add(car);
        }
    }

    private Car getWinner() {
        Car winner = this.cars.get(0);
        for (Car racer : cars) {
            winner = findWinner(winner, racer);
        }
        return winner;
    }

    private static Car findWinner(Car winner, Car racer) {
        if (racer.compareWinner(winner)) {
            winner = racer;
        }
        return winner;
    }

    private static boolean isDuplicate(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);
        return cars.size() != carSet.size();
    }
}
