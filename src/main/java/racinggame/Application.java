package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.service.RacingGameService;
import racinggame.validator.RacingGameInputValidator;
import racinggame.view.RacingGameResultView;
import racinggame.view.UserInputView;

public class Application {
    public static void main(String[] args) {
        RacingGameInputValidator racingGameInputValidator = new RacingGameInputValidator();
        UserInputView userInputView = new UserInputView(racingGameInputValidator);
        RacingGameResultView racingGameResultView = new RacingGameResultView();
        RacingGameService racingGameService = new RacingGameService();

        RacingGameController racingGameController = new RacingGameController(userInputView, racingGameResultView, racingGameService);
        racingGameController.startGame();
    }
}
