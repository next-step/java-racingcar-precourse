package controller;

import model.RacingCar;
import service.RacingGameService;
import view.UserInputView;

import java.util.ArrayList;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final UserInputView userInputView;

    public RacingGameController() {
        racingGameService = new RacingGameService();
        userInputView = new UserInputView();
    }

    public void startGame() {

        ArrayList<RacingCar> carNames = userInputView.getRacingCars();
        int attempt = userInputView.getAttemptNumber();

        racingGameService.playRacingGame(carNames, attempt);

    }
}
