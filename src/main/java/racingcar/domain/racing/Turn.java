package racingcar.domain.racing;

public class Turn {
    private final int ZERO_BASE = 0;
    private int turnValue;
    private int currentTurn;

    public Turn(int turnValue) {
        turnValueValidator(turnValue);
        this.turnValue = turnValue;
        this.currentTurn = ZERO_BASE;
    }

    private void turnValueValidator(int turnValue) {
        if (Integer.valueOf(turnValue) < 1)
            throw new IllegalArgumentException();
    }

    public boolean isOver() {
        return currentTurn >= turnValue;
    }

    public void increaseCurrentTurn() {
        currentTurn++;
    }

    public int getTurnValue() {
        return turnValue;
    }
}
