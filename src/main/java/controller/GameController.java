package controller;

import java.util.List;
import model.Game;
import view.InputView;

public class GameController {

    public static void playGame() {

        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();

        Game game = new Game(carNames);
    }

}
