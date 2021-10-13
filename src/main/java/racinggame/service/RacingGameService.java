package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;


public class RacingGameService {
    private Cars cars;
    private RacingResult racingResult;

    public RacingGameService() {
        racingResult = new RacingResult();
    }

    public void makeCars(String carsName) {
        this.cars = new Cars(carsName);
    }

    public RacingResult setRacingCar() {
        for (String car : cars.cars) {
            Car racingCar = new Car(car);
            racingResult.addResult(racingCar);
        }
        return racingResult;
    }

    public void moveCar(RacingResult racingResult) {
        for (int i = 0; i < racingResult.result.size(); i++) {
            Car racingCar = racingResult.result.get(i);
            racingCar.play();
        }
    }

    public Winner findWinner(RacingResult racingResult) {
        Winner winner = new Winner(racingResult);
        return winner;
    }
}
