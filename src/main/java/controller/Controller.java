package controller;

import java.util.List;
import java.util.Map;
import model.Game;
import utils.InputValidator;
import view.InputView;
import view.MoveView;
import view.WinnerView;

public class Controller {

    public static void playGame() {
        List<String> names = getNames();
        Game game = new Game(names);

        int attemptNum = getAttemptNum();

        MoveView.printResultMessage();
        for (int i = 0; i < attemptNum; i++) {
            Map<String, Integer> positions = game.play();
            MoveView.printResult(positions);
        }

        List<String> winners = game.getWinners();
        WinnerView.printWinners(winners);
    }

    private static List<String> getNames() {
        List<String> names = List.of(InputView.inputCarNames().split(","));
        InputValidator.validateNames(names);
        return names;
    }

    private static int getAttemptNum() {
        String attemptNumInput = InputView.inputAttemptNum();
        InputValidator.validateAttemptNum(attemptNumInput);
        return Integer.parseInt(attemptNumInput);
    }
}
