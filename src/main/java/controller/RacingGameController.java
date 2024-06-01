package controller;


import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {
    public static void run() {
        String[] carNames = InputView.getCarNames();
        int numberOfAttempts = InputView.getNumberOfAttempts();

        RacingGame game = new RacingGame(carNames, numberOfAttempts);
        game.play();

        ResultView.printRace(game.getCars());
        ResultView.printWinners(game.getWinners());
    }
}


