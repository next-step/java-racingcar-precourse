package service.impl;

import domain.Car;
import service.RacingGameService;

import java.util.List;

public class RacingGameServiceImpl implements RacingGameService {
    @Override
    public void race(List<Car> cars, int trialNumber) {

        for (int round = 0; round < trialNumber; round++) {
            for (Car car : cars) {
                tryMove(car, round);
            }
        }
    }

    @Override
    public List<Car> decideWinner(List<Car> cars) {
        int maxMoveCount = cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
        return cars.stream().filter(car -> car.getMoveCount() == maxMoveCount).toList();
    }

    private void tryMove(Car car, int round) {
        if (matchesRandomCondition()) {
            car.move(round);
        }
    }

    private boolean matchesRandomCondition() {
        return Math.floor(Math.random() * 10) >= 4;
    }
}
