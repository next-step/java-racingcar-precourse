package controller;

import java.util.function.Supplier;
import model.CarMoveRule;
import model.Cars;
import model.RaceResult;
import model.RacingGame;
import model.RandomCarMoveRule;
import model.Round;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = retryUntilCorrectValue(() -> new Cars(inputView.inputCarNames()));
        Round round = retryUntilCorrectValue(() -> new Round(inputView.inputRound()));

        CarMoveRule carMoveRule = new RandomCarMoveRule();

        RacingGame racingGame = new RacingGame(cars, round, carMoveRule);
        RaceResult raceResult = racingGame.race();
    }

    private <T> T retryUntilCorrectValue(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}