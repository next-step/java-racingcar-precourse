package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.utils.Result;
import racinggame.utils.Winner;

import java.util.ArrayList;
import java.util.List;


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
        Winner winner = new Winner();
        for (int i = 0; i < result.result.size(); i++) {
            winner.winner.put(result.result.get(i).getMoveCnt(), result.result.get(i).getCarName());
        }

        int winnerCnt = winner.winner.lastKey();
        List<Integer> remove = new ArrayList<>();
        for (int key : winner.winner.keySet()) {
            if (key != winnerCnt) {
                remove.add(key);
            }
        }

        for(int i = 0; i < remove.size(); i++) {
            winner.winner.remove(remove.get(i));
        }
        return winner;
    }
}
