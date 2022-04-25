package racingcar.states;

import racingcar.Context;
import racingcar.GameBoard;
import racingcar.GameController;
import racingcar.Laps;
import racingcar.State;

public class InputLapCountState implements State {

    private GameBoard gameBoard;
    private GameController gameController;

    public InputLapCountState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printLapCountInputRequestMessage();
    }

    @Override
    public Context readInput() {
        Laps laps = gameController.readLapCount();
        Context context = new Context(laps);
        return context;
    }

    @Override
    public void evaluateData(Context context) {
        gameController.registerLapsCount(context.getLaps());
    }

    @Override
    public void nextState() {
        gameBoard.setState(gameBoard.getOnLapState());
    }
}
