package racingcar.model.dto;

public class RacingResult {
    private final String name;
    private final int move;
    public final Boolean isWinner;

    public RacingResult(String name, int move, Boolean isWinner) {
        this.name = name;
        this.move = move;
        this.isWinner = isWinner;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public Boolean getWinner() {
        return isWinner;
    }
}
