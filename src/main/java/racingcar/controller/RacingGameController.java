package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameView racingGameView;
    private Cars cars;
    private int count;

    public RacingGameController(RacingGameView racingGameView) {
        this.racingGameView = racingGameView;
    }

    public void start() {
        this.insertGameInfo();

        this.playGame();

        this.racingGameView.printWinner(this.cars.getHighestScoreCars());
    }

    private void insertGameInfo() {
        this.cars = this.racingGameView.createCars();
        this.count = this.racingGameView.insertTryCount();
    }

    private void playGame() {
        this.racingGameView.printExecute();
        for (int i = 0; i < count; i++) {
            this.cars.moveForwardRandom();
            this.racingGameView.printExecuteResult(this.cars.getCarList());
        }
    }
}
