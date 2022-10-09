package racingcar.domain;

import java.util.ArrayList;

import static racingcar.constant.Constant.MAX_RACE_COUNT;
import static racingcar.constant.Constant.MIN_RACE_COUNT;

public class RacingGame {
    private final Cars cars;
    private final GameProcess gameProcess;


    public RacingGame(String carNames) {
        this.cars = Cars.createParticipatingCars(carNames);
        this.gameProcess = new GameProcess(new ArrayList<>());
    }

    public void play(int count) {
        while (count > 0) {
            moveAllCars();
            saveGameProcess(cars);
            count--;
        }
    }

    private void moveAllCars() {
        for (Car car : cars.getCarList()) {
            moveEachCar(car);
        }
    }

    private void moveEachCar(Car car) {
        car.move(Common.getRandomNumber(MIN_RACE_COUNT, MAX_RACE_COUNT));
    }

    private void saveGameProcess(Cars cars) {
        gameProcess.saveProcess(cars);
    }

    public GameProcess getGameProcesses() {
        return gameProcess;
    }


    public Cars getWinner() {
        int winnerScore = cars.getWinnerScore();
        Cars winnerCars = cars.setWinnerCars(winnerScore);
        return winnerCars;
    }

    public Cars getCars() {
        return cars;
    }


}
