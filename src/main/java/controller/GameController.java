package controller;

import java.util.List;
import parser.InputParser;
import service.GameService;
import validator.AttemptValidator;
import validator.CarNamesValidator;
import view.InputView;

public class GameController {

    private final InputView inputView;
    private final GameService gameService;

    public GameController() {
        this.inputView = new InputView();
        this.gameService = new GameService();
    }

    public void play() {
        gameService.play(obtainCarNames(), obtainAttempt());
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
