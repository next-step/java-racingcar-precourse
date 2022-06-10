package racingcar.controller;

import racingcar.domain.car.Record;
import racingcar.domain.car.Cars;
import racingcar.domain.winner.Winners;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    private Cars cars;
    private Record record;

    public GameController() {
        this.cars = new Cars(InputView.askNameOfCars());
        this.record = new Record();
    }

    public void startGame() {
        moveCars();
        showResult();
    }

    private void showResult() {
        ResultView resultView = new ResultView(getWinner(), record);
        resultView.show();
    }
    private void moveCars() {
        int count = InputView.getNumber();
        for (int i = 1; i <= count; i++) {
            this.cars = cars.move();
            record.add(i, this.cars);
        }
    }

    private Cars getWinner() {
        Winners winners = new Winners();
        return winners.findWinners(this.cars);
    }


}
