package racinggame.controller;

import racinggame.model.*;
import racinggame.service.RacingService;
import racinggame.view.OutputView;
import racinggame.view.UserInputView;

public class GameController {
    public void start() {
        CarNames carNames = getValidCarNames();
        CarGroup groups = new CarGroup(carNames);
        Round round = getValidRound();

        new RacingService(groups, round).run();
    }

    public Round getValidRound() {
        boolean isValid;
        String input;

        do {
            System.out.println(OutputView.ROUND_INPUT_NOTICE_STR);
            input = UserInputView.getUserInput();
            isValid = checkRoundValidate(input);
        } while(!isValid);

        return new Round(input);
    }

    public boolean checkRoundValidate(String input) {
        try {
            new Round(input);
        } catch (NumberFormatException e) {
            System.out.println(OutputView.ERR_ROUND_INPUT);
            return false;
        }
        return true;
    }

    public CarNames getValidCarNames() {
        boolean isValid;
        String input;

        do {
            System.out.println(OutputView.CAR_NAMES_INPUT_NOTICE_STR);
            input = UserInputView.getUserInput();
            isValid = checkCarNamesValidate(input);
        } while (!isValid);

        return new CarNames(input);
    }

    public boolean checkCarNamesValidate(String userInput) {
        boolean isValid = true;
        CarNames carNames = new CarNames(userInput);

        if (!carNames.isValidCarNames()) {
            isValid = false;
            System.out.println(OutputView.ERR_CAR_NAMES_INPUT);
        }
        return isValid;

    }


}
