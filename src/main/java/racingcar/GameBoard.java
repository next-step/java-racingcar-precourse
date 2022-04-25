package racingcar;

import racingcar.states.CloseState;
import racingcar.states.ExitState;
import racingcar.states.InitState;
import racingcar.states.InputCarNamesState;
import racingcar.states.InputLapCountState;
import racingcar.states.LapResultState;
import racingcar.states.OnLapState;
import racingcar.states.WinnerResultState;

public class GameBoard {
    private GameController gameController;

    private InitState initState;
    private InputCarNamesState inputCarNamesState;
    private InputLapCountState inputLapCountState;
    private OnLapState onLapState;
    private LapResultState lapResultState;
    private WinnerResultState winnerResultState;
    private CloseState closeState;
    private ExitState exitState;
    private State gameState;

    public GameBoard(GameController controller) {
        gameController = controller;
        initializeGameStates(this, gameController);
    }

    void initializeGameStates(GameBoard board, GameController controller) {
        initState = new InitState(board, controller);
        inputCarNamesState = new InputCarNamesState(board, controller);
        inputLapCountState = new InputLapCountState(board, controller);
        onLapState = new OnLapState(board, controller);
        lapResultState = new LapResultState(board, controller);
        winnerResultState = new WinnerResultState(board, controller);
        closeState = new CloseState(board, controller);
        exitState = new ExitState(board, controller);
    }

    public void run() {
        setState(initState);

        while (gameState.equals(exitState) == false) {
            gameState.viewUpdate();
            Context context = gameState.readInput();
            gameState.evaluateData(context);
            gameState.nextState();
        }
    }

    public void setState(State state) {
        gameState = state;
    }

    public State getInitState() {
        return initState;
    }
    public State getInputCarNamesState() {
        return inputCarNamesState;
    }
    public State getInputLapCountState() {
        return inputLapCountState;
    }
    public State getOnLapState() {
        return onLapState;
    }
    public State getLapResultState() {
        return lapResultState;
    }
    public State getWinnerResultState() {
        return winnerResultState;
    }
    public State getCloseState() {
        return closeState;
    }
    public State getExitState() {
        return exitState;
    }
}
