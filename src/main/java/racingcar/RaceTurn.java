package racingcar;

public class RaceTurn {
    public static final String ONLY_POSITIVE_INTEGER = "[ERROR] 0이상의 정수를 입력해 주세요.";

    private int turn;

    public RaceTurn(int turn) {
        this.turn = turn;
    }

    public RaceTurn(String inputTurn) throws IllegalArgumentException {
        validateTurn(inputTurn);
        this.turn = Integer.parseInt(inputTurn);
    }

    private void validateTurn(String turn) {
        if(!isPositiveInteger(turn)) {
            throw new IllegalArgumentException(ONLY_POSITIVE_INTEGER);
        }
    }

    private boolean isPositiveInteger(String turn) {
        String pattern = "\\d*";
        return turn.matches(pattern);
    }

    public void decrease() {
        turn--;
    }

    public boolean isFinished() {
        return turn == 0;
    }


}
