package racing;

public enum GameState {
    WAIT_FOR_INPUT_NAMES,
    WAIT_FOR_INPUT_ROUND,
    READY_FOR_RESULT,
    ;

    public boolean isWaitForInputName() {
        return this == GameState.WAIT_FOR_INPUT_NAMES;
    }

    public boolean isWaitForInputRound() {
        return this == GameState.WAIT_FOR_INPUT_ROUND;
    }

    public boolean isReadyForResult() {
        return this == GameState.READY_FOR_RESULT;
    }
}