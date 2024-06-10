package racingcar.controller;

import racingcar.model.Validator;
import racingcar.view.InputView;

public class Controller {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView();

    private String getCarNamesUserInput() {
        String input = inputView.requestCarNamesMessage();
        return checkValidationCarNames(input);
    }

    private String checkValidationCarNames(String input) {
        try {
            validator.checkCarsName(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarNamesUserInput();
        }
    }

    private String getTrialNumberUserInput() {
        String input = inputView.requestTrialNumberMessage();
        return checkValidationTrialNumber(input);
    }

    private String checkValidationTrialNumber(String input) {
        try {
            validator.checkTrialNumber(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getTrialNumberUserInput();
        }
    }
}
