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
    public List<Car> decideWinner(List<Car> player) {
        return null;
    }

    private void tryMove(Car car, int round) {
        if (Math.floor(Math.random() * 10) >= 4) {
            car.move(round);
        }
    }
}
