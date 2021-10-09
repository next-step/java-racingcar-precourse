package racinggame.controller;

import racinggame.exception.ValidationException;
import racinggame.model.RacingCars;
import racinggame.model.Round;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RaceController {
    private InputView inputView;
    private OutputView outputView;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        inputCarName();
        inputRacingRound();

    }

    private void inputCarName() {
        RacingCars racingCars;
        try {
            racingCars = new RacingCars(inputView.inputCarName());
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputCarName();
        }
    }

    private void inputRacingRound() {
        Round round;
        try {
            round = new Round(inputView.inputRacingRound());
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputRacingRound();
        }
    }

}
