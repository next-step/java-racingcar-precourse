package racingcar.model;

public class Turn {

    private Integer turnCount;

    public Turn(Integer turnCount) {
        this.turnCount = turnCount;
    }

    public boolean hasNextTurn() {
        return this.turnCount > 0;
    }

    public void next() {
        this.turnCount--;
    }
}
