package racingcar.controller;

import racingcar.common.InfoMessage;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.service.GameService;
import racingcar.service.InputService;
import racingcar.service.ResultService;
import racingcar.ui.Input;
import racingcar.ui.Output;

public class RacingController {

    private Input input;
    private ResultService resultService;
    private InputService inputService;
    private GameService gameService;
    private Cars cars;
    private Game game;

    public void run() {
        initCarService();
        inputToStartGame();
        processGame();
        showResult();
    }

    private void initCarService() {
        resultService = new ResultService();
    }

    private void inputToStartGame() {
        cars = inputCarName();
        inputService = new InputService(cars);
        duplicateCheck();
        game = inputRound();
        gameService = new GameService(game);
    }

    private Cars inputCarName() {
        Output.printMessage(InfoMessage.INPUT_CAR_NAME);
        try {
            input = new Input();
            return new Cars(input.splitCarNames(input.getInput()));
        } catch (IllegalArgumentException e) {
            Output.printMessageWithLineSpacing(e.getMessage());
            return inputCarName();
        }
    }

    private void duplicateCheck() {
        try {
            inputService.duplicateValidation();
        } catch (IllegalArgumentException e) {
            Output.printMessageWithLineSpacing(e.getMessage());
            inputService.setCars(inputCarName());
        }
    }

    private Game inputRound() {
        Output.printMessageWithLineSpacing(InfoMessage.INPUT_MOVEMENT_LIMIT);
        try {
            input = new Input();
            return new Game(inputService.getCars(), new Round(input.getInput()));
        } catch (IllegalArgumentException e) {
            Output.printMessageWithLineSpacing(e.getMessage());
            return inputRound();
        }
    }

    private void processGame() {
        Output.printDoubleLineSpacing();
        Output.printMessageWithLineSpacing(InfoMessage.OUTPUT_RUN_RESULT);
        for (int i = 0; i < game.getRound().getRoundNum(); i++) {
            gameService.playGame(game);
            Output.printLineSpacing();
        }
    }

    private void showResult() {
        resultService.determineMaxPosition(game);
        resultService.determineWinners(game);
        Output.printWinners(resultService.getWinners());
    }

}
