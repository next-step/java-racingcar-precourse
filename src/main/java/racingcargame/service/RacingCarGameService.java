package racingcargame.service;

import racingcargame.domain.Cars;

public class RacingCarGameService {
    Cars cars;
    StringBuilder raceResult;

    public void makeCars(String carNames) {
        cars = Cars.makeCars(carNames);
    }

    public void race(Integer moveCount) {
        raceResult = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            cars.randomMove();
            raceResult.append(cars.getResultString());
            raceResult.append(System.lineSeparator());
        }
    }

    public String getResultString() {
        return raceResult.toString();
    }
}
