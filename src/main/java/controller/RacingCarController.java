package controller;

import model.RacingCarGame;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {
        String[] carNames = inputView.inputCarNames();
        int movementCount = inputView.inputMovementCount();

        RacingCarGame game = new RacingCarGame(carNames, movementCount);

        outputView.printResultMessage();
        for (int i = 0; i < movementCount; i++) {
            outputView.printProgress(game.playOneRound());
        }
    }

}
