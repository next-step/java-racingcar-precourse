package controller;

import view.InputView;

public class RaceController {

    private final InputView inputView;

    public RaceController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = new Cars(inputView.inputCarNames());
    }
}
