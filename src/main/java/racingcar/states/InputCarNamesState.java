package racingcar.states;

import racingcar.CommaSeparatedCarNames;
import racingcar.Context;
import racingcar.GameBoard;
import racingcar.GameController;
import racingcar.State;

public class InputCarNamesState implements State {

    private GameBoard gameBoard;
    private GameController gameController;

    public InputCarNamesState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printCarNamesInputRequestMessage();
    }

    @Override
    public Context readInput() {
        CommaSeparatedCarNames car_names = gameController.readCarNames();
        Context context = new Context(car_names);
        return context;
    }

    @Override
    public void evaluateData(Context context) {
        gameController.registerCarEntries(context.getCarNames());
    }

    @Override
    public void nextState() {
        gameBoard.setState(gameBoard.getInputLapCountState());
    }
}
