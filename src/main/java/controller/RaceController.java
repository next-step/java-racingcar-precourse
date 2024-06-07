package controller;

import model.Cars;
import model.Round;
import view.InputView;

public class RaceController {

    private final InputView inputView;

    public RaceController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = new Cars(inputView.inputCarNames());
        Round round = new Round(inputView.inputRound());
    }
}