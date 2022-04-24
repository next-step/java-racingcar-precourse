package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.model.Round;
import racingcar.util.RandomNumberUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final Round round;

    public RacingGame() {
        this.cars = InputView.inputUsers();
        this.round = InputView.inputRound();
    }

    public GameResult start() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < round.getRound(); i++) {
            playRound();
            ResultView.printRound(cars);
        }

        return new GameResult(cars);
    }

    private void playRound() {
        for (Car car : cars) {
            car.drive(RandomNumberUtils.getRandomNumber());
        }
    }
}
