package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Result;
import racinggame.domain.Winner;


public class RacingGameService {
    private Cars cars;
    private Result result;

    public RacingGameService() {
        result = new Result();
    }

    public void makeCars(String carsName) {
        this.cars = new Cars(carsName);
    }

    public Result makeCar() {
        for (String car : cars.cars) {
            Car racingCar = new Car(car);
            result.addResult(racingCar);
        }
        return result;
    }

    public void moveCar(Result result) {
        for (int i = 0; i < result.result.size(); i++) {
            Car racingCar = result.result.get(i);
            racingCar.play();
        }
    }


    public Winner findWinner(Result result) {
        Winner winner = new Winner(result);
        return winner;
    }
}
