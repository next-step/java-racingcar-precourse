package racingcar.states;

import racingcar.Context;
import racingcar.GameBoard;
import racingcar.GameController;
import racingcar.State;

public class CloseState implements State {

    private GameBoard gameBoard;
    private GameController gameController;

    public CloseState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printCloseMessage();
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
        gameBoard.setState(gameBoard.getExitState());
    }
}
