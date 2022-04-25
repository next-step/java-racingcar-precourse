package racingcar.domain;

public class RoundManager {

    public static final int FIRST_ROUND = 1;

    private final RoundNumber totalRound;
    private RoundNumber currentRound;
    private final Rounds rounds;

    public RoundManager(int totalRound) {
        this.totalRound = new RoundNumber(totalRound);
        this.currentRound = new RoundNumber(FIRST_ROUND);
        this.rounds = new Rounds(totalRound);
    }

    public boolean isNotEnded() {
        return !totalRound.isNext(currentRound);
    }

    public void nextRound() {
        currentRound = currentRound.nextRound();
    }

    public Round getCurrentRound() {
        return rounds.getRound(currentRound);
    }

    public Round getLastRound() {
        return rounds.getRound(totalRound);
    }

    public Rounds getRounds() {
        return rounds;
    }
}
