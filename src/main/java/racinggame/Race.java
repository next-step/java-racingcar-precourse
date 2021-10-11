package racinggame;

public class Race {
    private Players players;
    private IterationCount iterationCount;

    public Race(Players players, IterationCount iterationCount) {
        this.players = players;
        this.iterationCount = iterationCount;
    }

    public static Race of(String[] carNames, int iterationCountInput) {
        return new Race(
                Players.createPlayersByCarNames(carNames),
                new IterationCount(iterationCountInput)
                );
    }

    public boolean isFinished() {
        return this.iterationCount.isZero();
    }

}
