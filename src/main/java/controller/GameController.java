package controller;

import java.util.List;
import parser.InputParser;
import validator.CarNamesValidator;
import view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void play() {
        obtainCarNames();
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
}
