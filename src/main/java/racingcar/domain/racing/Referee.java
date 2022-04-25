package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.result.GoOrStop;
import racingcar.domain.result.Result;
import racingcar.domain.result.WinNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {

    private Cars cars;
    private WinNames winNames;
    private Result result;

    public Referee(Cars cars) {
        this.cars = cars;
        this.winNames = new WinNames(new ArrayList<>());
        this.result = new Result(winNames);
    }

    public void turnOver(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            turnOver(cars.get(i), RandomNumber.generateRandomNumber());
        }
    }

    public void turnOver(Car car, int randomNumber) {
        if (randomNumber > 3) {
            moving(GoOrStop.GO, car);
        }
    }

    private void moving(GoOrStop goOrStop, Car car) {
        if (goOrStop.isGo())
            car.moveForward();
    }

    public String whoWin() {
        return getResult(sort()).getWinners();
    }

    private List<Car> sort() {
        Collections.sort(cars.getCars(), (firstOne, secondOne)
                -> secondOne.getCarPosition().getPosition() - firstOne.getCarPosition().getPosition());
        return cars.getCars();
    }

    private Result getResult(List<Car> sortedResult) {
        sortedResult.forEach(car -> {
            if (car.getCarPosition().getPosition() == getHighestPosition(sortedResult)) {
                result.addWinner(car.getCarName());
            }
        });
        return result;
    }

    private int getHighestPosition(List<Car> sortedResult) {
        return sortedResult.get(0).getCarPosition().getPosition();
    }
}
