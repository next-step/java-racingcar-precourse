package racinggame.domain;

public class Round {
    private int roundCount;
    private int currentRound;

    public Round(int round) {
        this.roundCount = round;
    }

    public boolean next() {
        if (isEnd()) {
            return false;
        }
        ++this.currentRound;

        return true;
    }

    private boolean isEnd() {
        return roundCount == currentRound;
    }
}
