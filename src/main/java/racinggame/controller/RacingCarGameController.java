package racinggame.controller;

import racinggame.model.RacingCar;
import racinggame.model.RacingCarGame;
import racinggame.view.ConsoleInputView;
import racinggame.view.ConsoleOutputView;

import java.util.List;

import static racinggame.constants.Messages.ERROR_MESSAGE;

public class RacingCarGameController {
    public void gameStart() {
        try {
            List<RacingCar> userInputCarNames = ConsoleInputView.getUserInputCarNames();
            int userInputMoveTryCount = ConsoleInputView.getUserInputCarMoveTryCount();

            RacingCarGame racingCarGame = new RacingCarGame(userInputCarNames, userInputMoveTryCount);

            ConsoleOutputView.displayGameResult(racingCarGame, userInputMoveTryCount);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            gameStart();
        }
    }
}
