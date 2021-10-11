package racinggame.controller;

import racinggame.exception.ValidationException;
import racinggame.model.RacingCars;
import racinggame.model.Round;
import racinggame.service.RacingService;
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
        RacingService racingService = new RacingService(inputCarName());
        racingService.playRounds(inputRacingRound().getRound());
    }

    private RacingCars inputCarName() {
        RacingCars racingCars = null;
        try {
            racingCars = new RacingCars(inputView.inputCarName());
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputCarName();
        }
        return racingCars;
    }

    private Round inputRacingRound() {
        Round round = null;
        try {
            round = new Round(inputView.inputRacingRound());
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputRacingRound();
        }
        return round;
    }

}
