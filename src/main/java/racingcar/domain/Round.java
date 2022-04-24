package racingcar.domain;

public class Round {
    private RoundCount roundCount;

    public Round(int roundCount) {
        this.roundCount = new RoundCount(roundCount);
    }

    public void playedRound() {
        roundCount.addRoundCount();
    }

    public boolean isGameEnd(RoundCount tryCount) {
        return roundCount.isEqualTryCount(tryCount);
    }
}
