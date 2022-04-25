package racingcar.states;

import racingcar.Context;
import racingcar.GameBoard;
import racingcar.GameController;
import racingcar.State;

public class OnLapState implements State {

    private GameBoard gameBoard;
    private GameController gameController;

    public OnLapState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        // Nothing
    }

    @Override
    public Context readInput() {
        return new Context();
    }

    @Override
    public void evaluateData(Context context) {
        gameController.takeALap();
    }

    @Override
    public void nextState() {
        gameBoard.setState(gameBoard.getLapResultState());
    }
}
