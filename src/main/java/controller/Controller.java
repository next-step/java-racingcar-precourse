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
        InputView.printCarNamesMesage();
        List<String> names = null;
        while (names == null) {
            try {
                names = List.of(InputView.getInput().split(","));
                InputValidator.validateNames(names);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                names = null;
            }
        }
        return names;
    }

    private static int getAttemptNum() {
        InputView.printAttemptNumMessage();
        String attemptNumInput = null;

        while (attemptNumInput == null) {
            try {
                attemptNumInput = InputView.getInput();
                InputValidator.validateAttemptNum(attemptNumInput);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                attemptNumInput = null;
            }
        }
        return Integer.parseInt(attemptNumInput);
    }
}
