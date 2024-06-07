package controller;

import java.util.function.Supplier;
import model.Cars;
import model.Round;
import view.InputView;

public class RaceController {

    private final InputView inputView;

    public RaceController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = retryUntilCorrectValue(() -> new Cars(inputView.inputCarNames()));
        Round round = retryUntilCorrectValue(() -> new Round(inputView.inputRound()));
    }

    private <T> T retryUntilCorrectValue(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                
            }
        }
    }
}