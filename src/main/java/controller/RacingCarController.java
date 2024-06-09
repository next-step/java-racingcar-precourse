package controller;

import model.RacingCarGame;
import view.InputView;

public class RacingCarController {

    private final InputView inputView = new InputView();

    public void startGame() {
        String[] carNames = inputView.inputCarNames();
        int movementCount = inputView.inputMovementCount();

        RacingCarGame game = new RacingCarGame(carNames, movementCount);

        game.startRacing();
    }

}
