package racingcar.domain;

public class RaceResult {

    private boolean winner = true;

    public void report(final RaceStatus raceStatus) {
        if (raceStatus.isLose()) {
            winner = false;
        }
    }

    public boolean isWinner() {
        return winner;
    }

}
