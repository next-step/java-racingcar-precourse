package controller;

import java.util.List;
import model.Game;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class GameController {

    public static void playGame() {

        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();

        Game game = new Game(carNames);

        OutputView.printResultString();

        for (int i = 0; i < attemptCount; i++) {
            for (String carName : carNames) {
                determineAdvanceAndReflect(carName, game);
            }

            OutputView.printProcess(game.getCarPosition());
        }
    }

    private static boolean isAdvance(int num) {
        return num >= 5;
    }

    private static void determineAdvanceAndReflect(String carName, Game game) {
        if (isAdvance(RandomNumberGenerator.getRandomNumber())) {
            game.advance(carName);
        }
    }

}
