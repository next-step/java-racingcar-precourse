package game.controller;

import game.domain.Cars;
import game.view.InputView;
import game.view.OutputView;
import game.view.constant.OutputMessage;
import java.util.List;

public class RacingGameController {

    private InputView inputView;
    private OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        List<String> carNames = inputView.enterCarNames();
        Cars cars = Cars.fromCarNames(carNames);

        int attemptCount = inputView.enterAttemptCount();
        System.out.println(OutputMessage.RESULT);
        for (int i = 0; i < attemptCount; i++) {
            cars.move();
            outputView.printResult(cars);
        }

        outputView.printWinner(cars);
    }

}
