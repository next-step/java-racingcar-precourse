package controller;

import model.RacingGameModel;
import view.RacingGameView;

public class RacingGameController {

    RacingGameView view = new RacingGameView();

    public void run(){
        RacingGameModel model = new RacingGameModel(view.getCarNames());
        int attemptCount = view.getAttemptCount();
        view.displayRaceResult();
        for (int i = 0; i < attemptCount; i++) {
            int randomNumber = model.generateRandomNumber();
            view.displayUpdatedCars(model.updateCars(randomNumber));
        }
        view.displayWinner(model.generateWinner(model.getCars()));
    }
}
