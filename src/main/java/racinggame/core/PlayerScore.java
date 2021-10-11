package racinggame.core;

public class PlayerScore {

    private static final int GAIN_POINT_NUMBER = 4;

    private int score = 0;

    public int getScore() {
        return this.score;
    }

    public void addScore(final int randomNumber) {
        if (canIncrease(randomNumber)) {
            this.score += 1;
        }
    }

    private boolean canIncrease(final int randomNumber) {
        return randomNumber >= GAIN_POINT_NUMBER;
    }

}
