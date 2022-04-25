package racingcar.states;

import racingcar.Context;
import racingcar.GameBoard;
import racingcar.GameController;
import racingcar.State;

public class LapResultState implements State {

    private GameBoard gameBoard;
    private GameController gameController;

    public LapResultState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printLapResult();
    }

    @Override
    public Context readInput() {
        return new Context();
    }

    @Override
    public void evaluateData(Context context) {
        // Nothing
    }

    @Override
    public void nextState() {
        if (gameController.isFinished()) {
            gameBoard.setState(gameBoard.getWinnerResultState());
        } else {
            gameBoard.setState(gameBoard.getOnLapState());
        }
    }
}
