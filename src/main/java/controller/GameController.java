package controller;

import java.util.List;
import parser.InputParser;
import service.GameService;
import validator.AttemptValidator;
import validator.CarNamesValidator;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final GameService gameService;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.gameService = new GameService();
        this.outputView = new OutputView();
    }

    public void play() {
        gameService.init(obtainCarNames());
        int attempt = obtainAttempt();

        outputView.printResult();
        while (attempt-- > 0) {
            outputView.printRoundOutput(gameService.playRound());
        }
        outputView.printWinners(gameService.whosTheWinner());
    }

    private List<String> obtainCarNames() {
        String input = inputView.obtainCarNames();
        try {
            CarNamesValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            obtainCarNames();
        }
        return InputParser.obtainCarNames(input);
    }

    private int obtainAttempt() {
        String input = inputView.obtainAttempt();
        try {
            AttemptValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            obtainAttempt();
        }
        return InputParser.obtainAttempt(input);
    }
}
